package com.maplogik.functional;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.maplogik.base.GetData;
import com.maplogik.pagelocators.StudentLoginPageLocators;
import com.maplogik.utilities.Utilities;

public class AfterUpdateScreenShot extends Utilities {

	public AfterUpdateScreenShot() {
		super();
	}

	@Test(priority = 0, dataProvider = "studentIdProvider", dataProviderClass = GetData.class)
	public void afterScreenShot(String id, String number, String certificate) {
		driver.get(student_login_url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		StudentLoginPageLocators.stdId.sendKeys(id);
		StudentLoginPageLocators.mobNum.sendKeys(number);
		StudentLoginPageLocators.loginButton.click();

		waitForTextMatch(StudentLoginPageLocators.testOtpLocator);
		String otp = getText(StudentLoginPageLocators.testOtp);
		StudentLoginPageLocators.loginOtp.sendKeys(otp, Keys.ENTER);

		takesScreenShot(StudentLoginPageLocators.overallPosition, after, id);
		click(StudentLoginPageLocators.logout);
	}
}
