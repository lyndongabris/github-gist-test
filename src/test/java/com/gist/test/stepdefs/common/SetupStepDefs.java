package com.gist.test.stepdefs.common;


import com.gist.test.util.PropertiesUtil;
import io.cucumber.java.Before;

public class SetupStepDefs {

    @Before
    public void setup() {
        PropertiesUtil.loadPropertiesFile("user.properties");
    }
}
