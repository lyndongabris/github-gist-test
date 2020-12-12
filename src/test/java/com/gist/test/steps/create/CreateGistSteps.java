package com.gist.test.steps.create;

import com.gist.test.api.data.requestdata.GistWriteData;
import com.gist.test.testdata.TestData;
import net.thucydides.core.annotations.Step;

public class CreateGistSteps {

    @Step
    public void createNewGist() {
        GistWriteData data =  GistWriteData.builder("Testing Gist Creation API")
                .withFile("myFile.txt", "This is a test Gist")
                .build();
        TestData.get().createGist(data);
    }
}
