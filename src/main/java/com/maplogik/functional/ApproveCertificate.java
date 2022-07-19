package com.maplogik.functional;

import org.testng.annotations.Test;
import com.maplogik.base.GetData;
import com.maplogik.pagelocators.AdminCerificationPageLocator;
import com.maplogik.pagelocators.AdminHomePageLocator;
import com.maplogik.pagelocators.AdminLoginPageLocator;
import com.maplogik.utilities.Utilities;

public class ApproveCertificate extends Utilities {

	public ApproveCertificate() {
		super();
	}

	@Test(priority = 0)
	public void adminLogin() {
		driver.get(admin_login_url);
		sendKey(AdminLoginPageLocator.loginId, admin_un);
		sendKey(AdminLoginPageLocator.loginPass, admin_pwd);
		click(AdminLoginPageLocator.loginButton);
		click(AdminHomePageLocator.coCurricularAchiv);
		waitForElementClickable(AdminHomePageLocator.certificationPageAdmin);
		click(AdminHomePageLocator.certificationPageAdmin);
	}

	@Test(priority = 1, dataProvider = "studentIdProvider", dataProviderClass = GetData.class)
	public void certificationApproval(String id, String number, String certificate) {
		selectByText(AdminCerificationPageLocator.showEntries, "100");
		clear(AdminCerificationPageLocator.searchTab);
		sendKey(AdminCerificationPageLocator.searchTab, id);
		int noOfRows = findElements(AdminCerificationPageLocator.pendingRows).size();
		for (int i = 1; i <= noOfRows; i++) {
			clear(AdminCerificationPageLocator.searchTab);
			sendKey(AdminCerificationPageLocator.searchTab, id);
			if (getText(AdminCerificationPageLocator.getStdId).equalsIgnoreCase(id)) {
				selectByText(AdminCerificationPageLocator.showEntries, "100");
				clear(AdminCerificationPageLocator.searchTab);
				sendKey(AdminCerificationPageLocator.searchTab, id);
				click(AdminCerificationPageLocator.certificationDetail);
				click(AdminCerificationPageLocator.approveCertificate);
			} else {
				break;
			}
		}
	}
}
