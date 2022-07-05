package com.maplogik.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.maplogik.base.BaseFactory;

public class Utilities extends BaseFactory {
	
	WebDriverWait wait;
	Actions actions;
	
	public Utilities() {
		super();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	/**
	 * 
	 * @param locator
	 * @return WebElement
	 */
	public WebElement waitForElementClickable(By locator) {
		WebElement element = driver.findElement(locator);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Wait for the given locator contains any number
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public boolean waitForTextMatch(By locator) {
		return wait.until(ExpectedConditions.textMatches(locator, Pattern.compile("\\d+")));
	}

	/**
	 * TakesScreenshot of the given locator
	 * 
	 * @param locator
	 * @param storeLocation
	 * @param id
	 */
	public void takesScreenShot(WebElement locator, String storeLocation, String id) {
		File screenShot = locator.getScreenshotAs(OutputType.FILE);
		String directory = storeLocation + id + ".png";
		File finalDirectory = new File(directory);
		try {
			FileHandler.copy(screenShot, finalDirectory);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param locator
	 * @return String
	 */
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	/**
	 * Click action by locator
	 * 
	 * @param locator
	 */
	public void click(By locator) {
		driver.findElement(locator).click();
	}

	/**
	 * SendKey Action
	 * 
	 * @param locator
	 * @param keyValue
	 */
	public void sendKey(By locator, String keyValue) {
		driver.findElement(locator).sendKeys(keyValue);
	}

	/**
	 * 
	 * @param locator
	 * @param text
	 */
	public void selectByText(By locator, String text) {
		WebElement element = driver.findElement(locator);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * Upload the file the given location
	 * 
	 * @param locator
	 * @param directory
	 */
	public void uploadFile(By locator, String directory) {
		driver.findElement(locator).sendKeys(new File(directory).getAbsolutePath());
	}
	
	/**
	 * 
	 * @param locator
	 * @return List<WebElement>
	 */
	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}
	
	/**
	 * 
	 * @param locator
	 */
	public void clear(By locator) {
		driver.findElement(locator).clear();
	}

	/**
	 * 
	 * @param locator
	 * @return List<WebElement>
	 */
	public List<WebElement> waitNumberOfElementsToBeMoreThan(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
		return wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, 1));
	}
	
	/**
	 * 
	 * @param locator
	 */
	public void clickMoveToElement(By locator) {
		actions = new Actions(driver);
		actions.click(driver.findElement(locator)).perform();;
	}
}
