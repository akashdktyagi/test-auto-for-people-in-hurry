package com.demosite.core.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Utils {

    public static byte[] takeScreenShot(WebDriver driver){
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        log.debug("Screen shot taken");
        return screenshot;
    }
    
}
