package com.demosite.core.contexts;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScnContext {
    Properties prop = new Properties();
    WebDriver driver;
}
