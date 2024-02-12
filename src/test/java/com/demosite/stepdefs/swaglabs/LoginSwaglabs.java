package com.demosite.stepdefs.swaglabs;

import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.model.Log;
import com.demosite.core.managers.BrowserManager;
import com.demosite.core.utils.Utils;
import com.demosite.pageobjects.swaglabs.LandingPage;
import com.demosite.pageobjects.swaglabs.LoginPageObjects;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LoginSwaglabs {

    WebDriver driver;
    Utils utils = new Utils();
    LoginPageObjects loginPage;
    LandingPage landingPage;

    @Before
    public void setUp(){
        String cmdLineArgBrowserName = System.getProperty("browsername");
        String browserName = cmdLineArgBrowserName==null ? "chrome": cmdLineArgBrowserName;
        driver = BrowserManager.getBrowser(browserName);

        loginPage = new LoginPageObjects(driver);
        landingPage = new LandingPage(driver);
        
    }

    @Given("I am on the Swaglabs login page")
    public void i_am_on_the_swaglabs_login_page() {
        driver.get(utils.getProperty("swaglabs.url"));
        Assertions.assertThat(driver.getTitle()).isEqualTo("Swag Labs");
    }

    @When("I enter valid username and password")
    public void enterValidUsernameAndPassword(List<Map<String, String>> data){
        log.info(data.toString());
        loginPage.enterUsername(data.get(0).get("username"));
        loginPage.enterPassword(data.get(0).get("password"));
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void shouldBeLoggedIn(){
        Assertions.assertThat(landingPage.isProductsListDisplayed()).isEqualTo(true);
    }


    @When("I enter invalid username and password")
    public void i_enter_invalid_username_and_password(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }



    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
