package com.maplogik.pagelocators;

import org.openqa.selenium.By;

public class AdminCerificationPageLocator {

	public static By approvedCertificate = By.xpath("//*[text()='Approved Certificate']");
	public static By pendingCerificate = By.xpath("//*[text()='pending Certificate']");
	public static By declinedCertificate = By.xpath("//*[text()='Decline Certificate']");
	
	public static By firstRow = By.xpath("//*[@id='datatable']/tbody/tr //td[text()='No matching records found']");
	public static By showEntries = By.xpath("//*[@name='datatable_length']");
	public static By searchTab = By.xpath("//*[@type='search']");
	public static By pendingRows = By.xpath("//*[@id='datatable']/tbody/tr");
	public static By certificationDetail = By.xpath("//*[@id='datatable']/tbody/tr[1]/td[6]/a[1]");
	public static By getStdId = By.xpath("//*[@id='datatable']/tbody/tr[1]/td[1]");
	
	public static By approveCertificate = By.xpath("(//*[@type='submit'])[2]");
	public static By declineCeritficate = By.xpath("(//*[@type='submit'])[1]");
}
