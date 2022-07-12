package com.MyTests;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mypages.BasePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReport extends BasePage {
	static ExtentTest test;
	static ExtentReports report;

	public ExtentReport(WebDriver driver) {
		super(driver);
	}
	
	@BeforeSuite
	public static void startTest() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		report = new ExtentReports(System.getProperty("user.dir") + timeStamp + " Results.html");
		test = report.startTest("ExtentDemo");
	}

}
