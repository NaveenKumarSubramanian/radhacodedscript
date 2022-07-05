package com.maplogik.pagelocators;

import org.openqa.selenium.By;

public class AdminLoginPageLocator {

	public static By loginId = By.id("login-email");
	public static By loginPass = By.id("login-password");
	public static By loginButton = By.xpath("//*[text()='Log in']");
}
