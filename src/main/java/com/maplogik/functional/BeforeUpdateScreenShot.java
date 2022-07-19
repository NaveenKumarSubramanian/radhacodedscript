package com.maplogik.functional;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.maplogik.base.GetData;
import com.maplogik.pagelocators.StudentCertificationPageLocators;
import com.maplogik.pagelocators.StudentLoginPageLocators;
import com.maplogik.utilities.Utilities;

public class BeforeUpdateScreenShot extends Utilities {

	public BeforeUpdateScreenShot() {
		super();
	}

	@Test(priority = 0, dataProvider = "studentIdProvider", dataProviderClass = GetData.class)
	public void beforeScreenShot(String id, String number, String certificate) {
		driver.get(student_login_url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		StudentLoginPageLocators.stdId.sendKeys(id);
		StudentLoginPageLocators.mobNum.sendKeys(number);
		StudentLoginPageLocators.loginButton.click();

		waitForTextMatch(StudentLoginPageLocators.testOtpLocator);

		String otp = getText(StudentLoginPageLocators.testOtp);
		StudentLoginPageLocators.loginOtp.sendKeys(otp, Keys.ENTER);

		takesScreenShot(StudentLoginPageLocators.overallPosition, before, id);

		String title = "Certificate of Achivement";
		String[] boardNames = { "Board of India", "Board of Tamilnadu", "Board of AndraPradesh", "Board of Kerala",
				"Board of Karnataka" };
		String authority = "College";
		int count = Integer.parseInt(certificate_add);
		for (int i = 0; i < count; i++) {
			click(StudentCertificationPageLocators.coCurricularAchiv);
			waitForElementClickable(StudentCertificationPageLocators.certificationPageStudent);
			click(StudentCertificationPageLocators.certificationPageStudent);
			sendKey(StudentCertificationPageLocators.title, title);
			sendKey(StudentCertificationPageLocators.issuingAuthority, authority);
			sendKey(StudentCertificationPageLocators.boardName, boardNames[i]);
			selectByText(StudentCertificationPageLocators.scopeOfCertification, "International");
			uploadFile(StudentCertificationPageLocators.certifiUpload, certificate);
			click(StudentCertificationPageLocators.submitButton);
		}
		click(StudentLoginPageLocators.logout);
	}
}
