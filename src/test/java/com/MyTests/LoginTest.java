/**
 * 
 */
package com.MyTests;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mypages.HomePage;
import com.mypages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;

/**
 * @author sambasivarao
 *
 */
public class LoginTest extends BaseTest {
	static ExtentTest test;
	static ExtentReports report;

	@BeforeClass
	public static void startTest() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		report = new ExtentReports(System.getProperty("user.dir") + timeStamp + " Results.html");
		test = report.startTest("ExtentDemo");
	}

	private static final boolean DataProvider = true;

	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		// System.out.println(title);
		// Assert.assertEquals(title, "HubSpot Login");
		if (title.equals("HubSpot Login")) {
			test.log(LogStatus.PASS, "Verified to the Login Page Title");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
	}

	@Test(priority = 2)
	public void verifyLoginPageHeaderTest() {
		String header = page.getInstance(LoginPage.class).getLoginPageHeader();
		// System.out.println(header);
		// Assert.assertEquals(header,"Don't have an account?");
		if (header.equals("Don't have an account?")) {
			test.log(LogStatus.PASS, "Verified to the Login Page Header");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
	}

	@DataProvider
	private Object[][] getLoginData() throws IOException {
		Object data[][] = ExcelDataConfig.ExcelData("Sheet1");
		return data;
	}

	@Test(dataProvider = "getLoginData")

	@BindingPriority(value = 3)
	private void doLogin(String username, String pwd) {
		HomePage homepage = page.getInstance(LoginPage.class).doLogin(username, pwd);
		//String headerHome = homepage.getHomePageHeader();
		 //System.out.println(headerHome);
		 //Assert.assertEquals(headerHome,"Getting started with HubSpot");
		if (homepage.equals("Navigate to the Login Page")) {
			test.log(LogStatus.PASS, "Navigated to the Home Page");
		}
		else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
	}

	@AfterClass
	public static void endTest() {
		report.endTest(test);
		report.flush();

	}
}
