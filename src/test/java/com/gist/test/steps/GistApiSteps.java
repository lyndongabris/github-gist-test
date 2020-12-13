package com.gist.test.steps;

import com.gist.test.api.data.requestdata.GistWriteData;
import com.gist.test.api.data.responsedata.GistDataList;
import com.gist.test.api.data.responsedata.GistResponseData;
import com.gist.test.api.endpoint.get.GetSpecificGistApiEndpoint;
import com.gist.test.api.response.get.GetGistApiResponse;
import com.gist.test.exception.GistTestRuntimeException;
import com.gist.test.testdata.TestData;
import com.gist.test.util.RetryUtil;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.time.temporal.ChronoUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GistApiSteps {
    private GistResponseData cachedGistResponse;
    private GistWriteData lastCreatedGist;
    private GistDataList gistList;

    private String lastGistId;
    private final String updateDescription = "Testing Gist Update API";
    private final String myFile1Filename = "myFile1.txt";
    private final String myFile1OriginalContent = "This will be updated";
    private final String myFile1UpdatedContent = "Text successfully updated";
    private final String myFile2Filename = "myFile2.txt";
    private final String myFile2Content = "This file will be deleted";

    private void createDefaultGist() {
        lastCreatedGist =  GistWriteData.builder("Testing Gist Creation API")
                .withFile("myFile.txt", "This is a test Gist")
                .build();
    }

    @Step
    public void createNewGist() {
        createDefaultGist();
        TestData.get().createGist(lastCreatedGist);
    }

    @Step
    public void getLastCreatedGist() {
        cachedGistResponse = TestData.get().getLastGist();
    }

    @Step
    public void descriptionOfReturnedGistMatchesPosted() {
        Assert.assertEquals("Returned gist description does not match last created", lastCreatedGist.getDescription(), cachedGistResponse.getDescription());
    }

    @Step
    public void filenameOfReturnedGistMatchesPosted() {
        Assert.assertEquals("Filename of returned value does not match the original",lastCreatedGist.getFiles().keySet().toArray()[0],
                cachedGistResponse.getFiles().keySet().toArray()[0]);
    }

    @Step
    public void fileContentsOfReturnedGistMatchesPosted() {
        Assert.assertEquals("File contents of returned value does not match the original",lastCreatedGist.getFiles().entrySet().stream().findFirst().get().getValue().getContent(),
                cachedGistResponse.getFiles().entrySet().stream().findFirst().get().getValue().getContent());
    }

    @Step
    public void createGistAndVerifyCreation() {
        createDefaultGist();
        cachedGistResponse = TestData.get().createGistAndConfirmCreation(lastCreatedGist);
    }

    @Step
    public void listGistsForUser() {
        gistList = TestData.get().getAllGistsForUser();
    }

    @Step
    public void verifyGistListContainsLastCreatedGist() {
        Assert.assertTrue("GIST list does not contain last created GIST id", gistList.getGists().stream()
                .map(GistResponseData::getId)
                .collect(Collectors.toList())
                .contains(cachedGistResponse.getId()));
    }

    @Step
    public void createGistWithTwoFiles() {
        lastCreatedGist = GistWriteData.builder(updateDescription)
                .withFile(myFile1Filename, myFile1OriginalContent)
                .withFile(myFile2Filename, myFile2Content)
                .build();
        lastGistId = TestData.get().createGist(lastCreatedGist);
    }

    @Step
    public void updatingPreviouslyCreatedGist() {
        lastCreatedGist = GistWriteData.builder(updateDescription)
                .withFile(myFile1Filename, myFile1UpdatedContent)
                .withFile(myFile2Filename, null)
                .build();
        TestData.get().updateGist(lastGistId, lastCreatedGist);
    }

    @Step
    public void gistUpdatedAsExpected() {
        Predicate<GetGistApiResponse> validation = response -> response.getDataObject().getGists().get(0).getFiles().size() == 1;
        cachedGistResponse = TestData.get().getUntilCondition(lastGistId, validation, "File size was not reduced for GIST as expected within timeout", 10);
        Assert.assertEquals("File has not been deleted", 1, cachedGistResponse.getFiles().size());
        Assert.assertEquals("File content has not been updated", myFile1UpdatedContent, cachedGistResponse.getFiles().entrySet().stream().findFirst().get().getValue().getContent());
    }

    @Step
    public void lastGistIsDeleted() {
        TestData.get().deleteGist(lastGistId);
    }

    @Step
    public void gistIsNoLongerAvailable() {
        Assert.assertEquals(404, TestData.get().getGistWithoutCheck(lastGistId).getStatusCode());
    }
}
