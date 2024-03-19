package com.demosite.pageobjects.swaglabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v119.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demosite.core.interactions.Interact;

public class LoginPageObjects extends Interact {
    
    WebDriver driver;

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginBtn;
    

    public LoginPageObjects(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String u){
        // username.sendKeys(u);
        setElement(loginBtn, u);
    }

    public void enterPassword(String p){
        password.sendKeys(p);
    }

    public void clickLoginButton(){
        //wait
        loginBtn.click();
    }


}
