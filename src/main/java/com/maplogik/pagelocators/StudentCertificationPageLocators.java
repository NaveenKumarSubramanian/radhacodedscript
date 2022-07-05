package com.maplogik.pagelocators;

import org.openqa.selenium.By;

public class StudentCertificationPageLocators {

	public static By coCurricularAchiv = By.xpath("//*[text()='Co Curricular Achievements']");
	
	public static By certificationPageStudent = By.xpath("//*[text()='Certifications']");

	public static By title = By.name("title");
	
	public static By issuingAuthority = By.name("issuing");
	
	public static By boardName = By.name("board_name");
	
	public static By scopeOfCertification = By.name("scope");
	
	public static By yearOfcertification = By.name("year");
	
	public static By selectYear = By.xpath("//*[@class='picker__select--year']");
	
	public static By selectMonth = By.xpath("//*[@class='picker__select--month']");
	
	public static By selectDate = By.xpath("//*[@id='pd-months-year_table'] //tbody/tr");
	
	public static By selectToday = By.xpath("//*[@class='picker__button--today']");
	
	public static By certifiUpload = By.name("certificate");
	
	public static By submitButton = By.id("submitbtn");
	
	
}
