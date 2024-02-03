package com.demosite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    WebDriver driver;
    By searchBox = By.name("q");
    By searchButton = By.name("btnK");

    public LandingPage(WebDriver driver){
        this.driver = driver;
    }
    
    public void enterTextInSearchBox(String text){
        driver.findElement(searchBox).sendKeys(text);
    }

    public void clickSearchButton(){
        driver.findElement(searchButton).click();
    }
    
}
