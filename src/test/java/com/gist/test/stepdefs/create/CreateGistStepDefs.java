package com.gist.test.stepdefs.create;

import com.gist.test.steps.create.CreateGistSteps;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class CreateGistStepDefs {

    @Steps
    private CreateGistSteps createGistSteps;

    @Given("^a new GIST is POSTed to the GitHub GIST API$")
    public void aNewGistIsPostedToTheGithubGistApi() {
        createGistSteps.createNewGist();
    }
}
