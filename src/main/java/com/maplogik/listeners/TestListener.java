package com.maplogik.listeners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.maplogik.utilities.Utilities;

public class TestListener extends Utilities implements ITestListener {
	
	private ExtentReports extentReports;
	private ExtentReports extent = Extentreport();
	private ExtentTest extentTest;

	public ExtentReports Extentreport() {
		extentReports = new ExtentReports();
		ExtentSparkReporter reporter = new ExtentSparkReporter(ExtentReport);
		reporter.config().setReportName("Maplogik Test Report");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("System", "WINDOWS");
		extentReports.setSystemInfo("Author", "RK");
		extentReports.setSystemInfo("Build", "1.0");
		extentReports.setSystemInfo("Team", "ADM");
		extentReports.setSystemInfo("Client Name", "Maplogik");

		extentReports.setReportUsesManualConfiguration(true);
		return extentReports;
	}

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extent.createTest(result.getMethod().getMethodName(),
				result.getMethod().getDescription());
		extentTest.assignCategory(result.getTestContext().getSuite().getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.pass(result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, result.getThrowable());
		
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			extentTest.fail(result.getMethod().getMethodName(),
					MediaEntityBuilder.createScreenCaptureFromPath("../"+takesScreenShotPage(driver, failedScreenshotLocation, dataAndTime())).build());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		WebDriver driver = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			extentTest.skip(result.getMethod().getMethodName(),
					MediaEntityBuilder.createScreenCaptureFromPath("../"+takesScreenShotPage(driver, failedScreenshotLocation, dataAndTime())).build());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
	}

	/**
	 * 
	 * @return
	 */
	public String dataAndTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH_mm_ss");
		Date date = new Date();
		return formatter.format(date);
	}
}
