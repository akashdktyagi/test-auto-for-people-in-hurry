package com.demosite.stepdefs;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v119.browser.Browser;
import org.testng.asserts.Assertion;

import com.demosite.core.contexts.ScnContext;
import com.demosite.core.managers.BrowserManager;
import com.demosite.core.utils.Utils;
import com.demosite.pageobjects.LandingPage;
import com.fasterxml.jackson.databind.JsonSerializable.Base;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class StepDefsApp{

    WebDriver driver;
    String url = "https://www.google.com";
    Scenario scenario;
    ScnContext context;

    @Before
    public void setUp(Scenario scenario){
        this.scenario = scenario;
    }

    public StepDefsApp(WebDriver context){
        this.driver = driver;
    }

    @AfterStep
    public void afterEachStep(){
        scenario.attach(Utils.takeScreenShot(driver), "image/png", scenario.getId());
    }

    @Given("I have a browser opened")
    public void i_have_a_browser_opened() {
        String cmdLineArgBrowserName = System.getProperty("browsername");
        String browserName = cmdLineArgBrowserName==null ? "chrome": cmdLineArgBrowserName;
        driver = BrowserManager.getBrowser(browserName);
        scenario.log("Browser Opened.");
    }

    @When("I navigate to url")
    public void i_navigate_to_url() {
        driver.get(url);
        scenario.log(url + " is opened.");
        log.info(url + " is opened.");
    }

    @When("I search {string}")
    public void i_search(String string) {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.enterTextInSearchBox(string);
        landingPage.clickSearchButton();
        // driver.findElement(By.name("q")).sendKeys(string);
        // driver.findElement(By.name("btnK")).click();
        scenario.log("seach for " + string);
    }

    @Then("I expect to see {string} in search result")
    public void i_expect_to_see_in_search_result(String string) {
        Assertions.assertThat(driver.getTitle()).contains(string);
        // Assertion assertion = new Assertion();
        // assertion.assertEquals(string, driver.getTitle().contains(string));
    }

    @After
    public void teardown(){
        driver.quit();
    }     
    
}
