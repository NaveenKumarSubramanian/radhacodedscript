package com.maplogik.pagelocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentLoginPageLocators {

	// By Locator
	public static By testOtpLocator = By.id("test_otp");

	public static By logout = By.xpath("//*[@href='http://maplogik.com/index.php/student/logout']");

	public static By testOtp = By.id("test_otp");
	
	// PageFactory
	@FindBy(id = "login-student-id")
	public static WebElement stdId;

	@FindBy(id = "login-mobile")
	public static WebElement mobNum;

	@FindBy(xpath = "//*[text()='Log in']")
	public static WebElement loginButton;

	@FindBy(id = "login-otp")
	public static WebElement loginOtp;

	@FindBy(xpath = "(//div[@class='card custom-card new-custom'])[4]")
	public static WebElement overallPosition;

}
