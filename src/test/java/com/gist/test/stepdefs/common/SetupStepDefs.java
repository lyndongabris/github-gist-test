package com.gist.test.stepdefs.common;

import com.gist.test.testdata.TestData;
import com.gist.test.util.PropertiesUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class SetupStepDefs {

    @Before
    public void setup() {
        PropertiesUtil.loadPropertiesFile("user.properties");
    }

    @After
    public void cleanup() {
        String deleteAfterTestString = PropertiesUtil.getSystem("delete.data.after.test");
        boolean deleteAfterTest = true;
        if (deleteAfterTestString != null && !deleteAfterTestString.isEmpty()) {
            deleteAfterTest = Boolean.parseBoolean(deleteAfterTestString);
        }
        if (deleteAfterTest) {
            TestData.get().deleteAllCreatedGists();
        }
    }
}
