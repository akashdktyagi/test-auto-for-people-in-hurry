package com.demosite.core.interactions;

import com.google.common.base.Preconditions;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

@Log4j2
@Data
public class Interact {

	protected WebDriver driver;
	private long timeOutInSeconds=10;

	public void clickElement(WebElement webElement) {
		try { Thread.sleep(3000);}catch (InterruptedException e) { e.printStackTrace(); }
		Preconditions.checkNotNull(webElement,"Object passed is Null. Unable to perform the operation");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds)) ;
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
		webElement.click();
		log.debug("Element is clicked. Element Description: " + webElement.toString());

	} 

	public void clickElement(By by) {
		try { Thread.sleep(3000);}catch (InterruptedException e) { e.printStackTrace(); }
		Preconditions.checkNotNull(by,"Object passed is Null. Unable to perform the operation");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.click();
		log.debug("Element is clicked. Element Description: " + element.toString());
	}
	
	public WebElement setElement(By by, String text) {
		try { Thread.sleep(3000);}catch (InterruptedException e) { e.printStackTrace(); }
		Preconditions.checkNotNull(by,"Object passed is Null. Unable to perform the operation");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.sendKeys(text);
		log.debug("Element is Set with text as: " + text + ". Element Description: " + by.toString());
		return element;
	}

    public WebElement setElement(WebElement element, String text) {
		try { Thread.sleep(3000);}catch (InterruptedException e) { e.printStackTrace(); }
		Preconditions.checkNotNull(element,"Object passed is Null. Unable to perform the operation");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(text);
		log.debug("Element is Set with text as: " + text + ". Element Description: " + element.toString());
		return element;
	}
	
	public String getAttribute(By by, String attName) {
		try { Thread.sleep(3000);}catch (InterruptedException e) { e.printStackTrace(); }
		Preconditions.checkNotNull(by,"Object passed is Null. Unable to perform the operation");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		String value = element.getAttribute(attName);
		log.debug("Get Attribute for element: " + by.toString() + " Attribute name: " + attName);
		return value;
	}
	
	public String getText(By by) {
		try { Thread.sleep(3000);}catch (InterruptedException e) { e.printStackTrace(); }
		Preconditions.checkNotNull(by,"Object passed is Null. Unable to perform the operation");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		String value = element.getText();
		log.debug("Get Text for element: " + by.toString() + " Text : " + value);
		return value;
	}

	public String getTitle() {
		try { Thread.sleep(3000);}catch (InterruptedException e) { e.printStackTrace(); }
		String value = driver.getTitle();
		log.debug("Title fetched: " + value);
		return value;
	}
	
	public List<WebElement> getListOfWebElements(By by){
		try { Thread.sleep(3000);}catch (InterruptedException e) { e.printStackTrace(); }
		Preconditions.checkNotNull(by,"Object passed is Null. Unable to perform the operation");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		log.debug("List of Elements returned for description: " + by.toString());
		return element.findElements(by);
	}
	
	public boolean validateElementIsDisplayed(By by) {
		try { Thread.sleep(3000);}catch (InterruptedException e) { e.printStackTrace(); }
		Preconditions.checkNotNull(by,"Object passed is Null. Unable to perform the operation");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		boolean b = driver.findElement(by).isDisplayed();
		log.debug("Element is Displayed status: " + by.toString());
		return b;
	}

    public boolean validateElementIsDisplayed(WebElement element) {
		try { Thread.sleep(3000);}catch (InterruptedException e) { e.printStackTrace(); }
		Preconditions.checkNotNull(element,"Object passed is Null. Unable to perform the operation");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		WebElement element1 = wait.until(ExpectedConditions.visibilityOf(element));
        boolean b = element.isDisplayed();
		log.debug("Element is Displayed status: " + element.toString());
		return b;
	}
	
	public void switchToSecondWindowTab() {
		String [] handles = (String[]) driver.getWindowHandles().toArray();
		driver.switchTo().window(handles[1]);
		log.debug("Browser Switched to second window tab.");
	}
	
	public void switchToDefaultWindowTab() {
		String [] handles = (String[]) driver.getWindowHandles().toArray();
		driver.switchTo().window(handles[0]);
		log.debug("Browser Switched to parent window tab.");
	}
	
	public byte[] takeScreenShot() {

		TakesScreenshot shot = (TakesScreenshot)driver;
		log.debug("Screen Shot taken for full driver. ");
		return shot.getScreenshotAs(OutputType.BYTES);
	}
	
	public byte[] takeScreenShot(By by) {
		Preconditions.checkNotNull(by,"Object passed is Null. Unable to perform the operation");
		TakesScreenshot shot = (TakesScreenshot)driver.findElement(by);
		log.debug("Screen Shot taken for element: " + by.toString() );
		return shot.getScreenshotAs(OutputType.BYTES);
	}
	
	public File takeScreenShotAsFile() {
		TakesScreenshot shot = (TakesScreenshot)driver;
		log.debug("Screen Shot taken for full driver and returned as a file.");
		return shot.getScreenshotAs(OutputType.FILE);
	}
	
	public File takeScreenShotAsFile(By by) {
		TakesScreenshot shot = (TakesScreenshot)driver.findElement(by);
		log.debug("Screen Shot taken for element and returned as a file. By descp: " + by.toString());
		return shot.getScreenshotAs(OutputType.FILE);
	}

}