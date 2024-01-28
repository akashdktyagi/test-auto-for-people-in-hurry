package com.demosite.stepdefs.app1;

import org.openqa.selenium.WebDriver;

import com.demosite.core.utils.Utils;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BaseStepsDefs {
    WebDriver driver;
    String url = "https://www.google.com";
    Scenario scenario;

    @Before
    public void setUp(Scenario scenario){
        this.scenario = scenario;
    }

    @AfterStep
    public void afterEachStep(){
        // if (scenario.isFailed()){

        // }
        scenario.attach(Utils.takeScreenShot(driver), "image/png", scenario.getId());
    }
}