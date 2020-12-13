package com.gist.test.testdata;

import com.gist.test.api.data.GistData;
import com.gist.test.api.data.requestdata.GistWriteData;
import com.gist.test.api.data.responsedata.GistDataList;
import com.gist.test.api.data.responsedata.GistResponseData;
import com.gist.test.api.endpoint.delete.DeleteGistApiEndpoint;
import com.gist.test.api.endpoint.get.GetSpecificGistApiEndpoint;
import com.gist.test.api.endpoint.get.ListAuthenticatedUsersGistsApiEndpoint;
import com.gist.test.api.endpoint.patch.PatchGistApiEndpoint;
import com.gist.test.api.endpoint.post.PostGistApiEndpoint;
import com.gist.test.api.response.AbstractApiResponse;
import com.gist.test.api.response.delete.DeleteGistApiResponse;
import com.gist.test.api.response.get.GetGistApiResponse;
import com.gist.test.api.response.patch.PatchGistApiResponse;
import com.gist.test.api.response.post.PostGistApiResponse;
import com.gist.test.exception.GistTestRuntimeException;
import com.gist.test.util.PropertiesUtil;
import com.gist.test.util.RetryUtil;
import net.serenitybdd.core.Serenity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TestData {
    private static final Logger LOG = LoggerFactory.getLogger(TestData.class);
    private List<String> createdGistIds;
    private static TestData instance;
    private String lastGistId;
    private GistWriteData lastGistWrite;

    private static final long RETRY_TIME_SECONDS = 10L;

    private void evidenceData(GistData data, String name) {
        Serenity.recordReportData().asEvidence().withTitle(name).andContents(data.toJson());
    }

    public static TestData get() {
        if (instance == null) {
            instance = new TestData();
        }
        return instance;
    }

    private List<String> getGistIds() {
        if (createdGistIds == null) {
            createdGistIds = new ArrayList<>();
        }
        return createdGistIds;
    }

    private void clearCreatedGistIds() {
        createdGistIds.clear();
    }

    public DeleteGistApiResponse deleteGist(String id) {
        return DeleteGistApiEndpoint.delete(getToken(), id);
    }

    public void deleteAllCreatedGists() {
        LOG.info("Deleting all created GISTs");
        createdGistIds.forEach(this::deleteGist);
        clearCreatedGistIds();
    }

    private String getToken() {
        String token = PropertiesUtil.getSystem("gist.token");
        if (token == null || token.isEmpty()) {
            throw new GistTestRuntimeException("NO GITHUB API TOKEN HAS BEEN DEFINED. Please add this to the user.properties file as gist.token");
        }
        return token;
    }

    public String createGist(GistWriteData data) {
        evidenceData(data, "Post Data");
        this.lastGistWrite = data;
        LOG.info("Posting new GIST");
        PostGistApiResponse response = PostGistApiEndpoint.create(getToken(), data);
        LOG.info("POST action completed");
        evidenceData(response.getDataObject(), "Post Response Data");
        String gistId = response.getDataObject().getGists().get(0).getId();
        getGistIds().add(gistId);
        lastGistId = gistId;
        return gistId;
    }

    public String updateGist(String id, GistWriteData data) {
        evidenceData(data, "Patch Data");
        LOG.info("Patching updated GIST");
        PatchGistApiResponse response = PatchGistApiEndpoint.update(getToken(), id, data);
        evidenceData(response.getDataObject(), "Patch response");
        String gistId = response.getDataObject().getGists().get(0).getId();
        lastGistId = gistId;
        return gistId;
    }

    public GistResponseData createGistAndConfirmCreation(GistWriteData data) {
        createGist(data);
        return getLastGist();
    }

    public GetGistApiResponse getGistWithoutCheck(String gistId) {
        return GetSpecificGistApiEndpoint.get(getToken(), gistId);
    }

    public GistResponseData getGist(String gistId) {
        Predicate<GetGistApiResponse> checkSuccess = AbstractApiResponse::isSuccessful;

        return getUntilCondition(gistId, checkSuccess, "Could not retrieve GIST within " + RETRY_TIME_SECONDS + " seconds", RETRY_TIME_SECONDS);
    }

    public GistResponseData getUntilCondition(String gistId, Predicate<GetGistApiResponse> condition, String message, long timeoutSeconds) {
        Supplier<GetGistApiResponse> getGist = () -> GetSpecificGistApiEndpoint.get(getToken(), gistId);
        LOG.info("Attempting to GET GIST with ID '{}' with timeout of '{}' seconds", gistId, timeoutSeconds);
        GetGistApiResponse response = RetryUtil.retryAction(getGist, condition, timeoutSeconds, ChronoUnit.SECONDS, message, true);
        evidenceData(response.getDataObject(), "GET response data");
        return response.getDataObject().getGists().get(0);
    }

    public GistResponseData getLastGist() {
        return getGist(lastGistId);
    }

    public GistDataList getAllGistsForUser() {
        LOG.info("Getting all GISTs for user");
        GetGistApiResponse response = ListAuthenticatedUsersGistsApiEndpoint.get(getToken());
        evidenceData(response.getDataObject(), "Authenticated User's GISTs");
        return response.getDataObject();
    }


    public void deleteAllListsForUser() {
        GistDataList listData =  ListAuthenticatedUsersGistsApiEndpoint.get(getToken()).getDataObject();
        List<String> ids = listData.getGists().stream().map(GistResponseData::getId).collect(Collectors.toList());
        ids.forEach(this::deleteGist);
    }
}
