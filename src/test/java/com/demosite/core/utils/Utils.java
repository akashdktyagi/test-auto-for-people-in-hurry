package com.demosite.core.utils;

import java.io.FileInputStream;
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
    
    public Properties readProperties(String fileName){
        Properties prop = new Properties();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            log.debug(fileName + " not found", e);
            e.printStackTrace();
        }
        return prop;
    }

    public String getProperty(String key){
        Properties prop = readProperties("config.properties");
        log.debug(prop.getProperty(key));
        return prop.getProperty(key);
    }
}
