package com.demosite.runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        glue = "com.demosite.stepdefs",
        dryRun = false,
        tags = "@t",
        plugin = {
                "html:target/cucumber-reports/index.html",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class RunTest extends AbstractTestNGCucumberTests {
        @DataProvider(parallel = true)
        @Override
        public Object[][] scenarios() {
           return super.scenarios();
        }
}

// mvn clean test -Dcucumber.options.tags="@swaglabs"