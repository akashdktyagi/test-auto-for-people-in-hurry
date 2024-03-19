package com.demosite.pageobjects.swaglabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demosite.core.interactions.Interact;

public class LandingPage extends Interact{
    WebDriver driver;

    @FindBy(id = "inventory_container")
    WebElement productsList;

    public LandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // public boolean isProductsListDisplayed(){
    //     return productsList.isDisplayed();
    // }

    public boolean isProductsListDisplayed(){
        return validateElementIsDisplayed(productsList);
    }
}
