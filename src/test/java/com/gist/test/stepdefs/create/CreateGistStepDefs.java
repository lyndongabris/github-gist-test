package com.gist.test.stepdefs.create;

import com.gist.test.steps.GistApiSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CreateGistStepDefs {

    @Steps
    private GistApiSteps gistApiSteps;

    @Given("^a new GIST is POSTed to the GitHub GIST API$")
    public void aNewGistIsPostedToTheGithubGistApi() {
        gistApiSteps.createNewGist();
    }

    @When("performing a GET on the created GIST")
    public void performingAGETOnTheCreatedGIST() {
        gistApiSteps.getLastCreatedGist();
    }

    @Then("the description matches the original value")
    public void theDescriptionMatchesTheOriginalValue() {
        gistApiSteps.descriptionOfReturnedGistMatchesPosted();
    }

    @Then("the filename matches the original value")
    public void theFilenameMatchesTheOriginalValue() {
        gistApiSteps.filenameOfReturnedGistMatchesPosted();
    }

    @Then("the content matches the original value")
    public void theContentMatchesTheOriginalValue() {
        gistApiSteps.fileContentsOfReturnedGistMatchesPosted();
    }

    @Given("a new GIST is POSTed to the GitHub GIST API and verified")
    public void aNewGISTIsPOSTedToTheGitHubGISTAPIAndVerified() {
        gistApiSteps.createGistAndVerifyCreation();
    }

    @When("performing a GET to list all GISTs for a user")
    public void performingAGETToListAllGISTsForAUser() {
        gistApiSteps.listGistsForUser();
    }

    @Then("the new GIST is present in the list")
    public void theNewGISTIsPresentInTheList() {
        gistApiSteps.verifyGistListContainsLastCreatedGist();
    }

    @Given("a new GIST with two files is POSTed to the GitHub GIST API")
    public void aNewGISTWithTwoFilesIsPOSTedToTheGitHubGISTAPI() {
        gistApiSteps.createGistWithTwoFiles();
        // Verifying creation
        gistApiSteps.getLastCreatedGist();
    }

    @When("performing a PATCH to update the created GIST")
    public void performingAPATCHToUpdateTheCreatedGIST() {
        gistApiSteps.updatingPreviouslyCreatedGist();
    }

    @Then("the update has been completed as expected")
    public void theUpdateHasBeenCompletedAsExpected() {
        gistApiSteps.gistUpdatedAsExpected();
    }
}
