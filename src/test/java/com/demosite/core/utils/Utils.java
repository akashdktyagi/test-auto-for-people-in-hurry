package com.demosite.core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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

    public void readProperties(String fileName){
        Properties prop = new Properties();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        try {
            prop.load(inputStream);
            String url = prop.getProperty("sit.url");
            System.out.println("URL: " + url);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
