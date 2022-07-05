package com.maplogik.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.maplogik.pagelocators.StudentLoginPageLocators;

public class BaseFactory {

	public WebDriver driver;
	public String after;
	public String before;
	public String driverLocation;
	public String student_login_url;
	public String admin_login_url;
	public String admin_un;
	public String admin_pwd;
	public String certificate_add;

	/**
	 * This is the Base to initiate the driver and 
	 * read the property file
	 */
	public BaseFactory() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("./src/main/resources/config.properties"));
			student_login_url = prop.getProperty("student_login_url");
			admin_login_url = prop.getProperty("admin_login_url");
			before = prop.getProperty("before");
			after = prop.getProperty("after");
			driverLocation = prop.getProperty("driverLocation");
			admin_un = prop.getProperty("admin_un");
			admin_pwd = prop.getProperty("admin_pwd");
			certificate_add = prop.getProperty("certificate_add");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.setProperty("webdriver.chrome.driver", driverLocation);
		driver = new ChromeDriver();
	}

	@BeforeTest
	public void openBrowser() {
		PageFactory.initElements(driver, StudentLoginPageLocators.class);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
