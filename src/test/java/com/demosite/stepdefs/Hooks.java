package com.demosite.stepdefs;

import org.openqa.selenium.WebDriver;

import com.demosite.core.contexts.ScnContext;
import com.demosite.core.utils.Utils;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    WebDriver driver;

    public Hooks(WebDriver driver){
        this.driver = driver;
    }
    
    @AfterStep
    public void afterEachStep(Scenario scenario){
        scenario.attach(Utils.takeScreenShot(driver), "image/png", scenario.getId());
    }
    
}
