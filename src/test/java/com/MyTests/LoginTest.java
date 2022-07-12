/**
 * 
 */
package com.MyTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mypages.HomePage;
import com.mypages.LoginPage;

import net.bytebuddy.implementation.bind.annotation.BindingPriority;

/**
 * @author sambasivarao
 *
 */
public class LoginTest extends BaseTest {

	private static final boolean DataProvider = true;
	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "HubSpot Login");
	}

	@Test(priority = 2)
	public void verifyLoginPageHeaderTest() {
		String header = page.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println(header);
		Assert.assertEquals(header, "Don't have an account?");
	}

	@DataProvider
	private Object[][] getLoginData() throws IOException {
      Object data [][] = ExcelDataConfig.ExcelData("Sheet1");
      return data;
	}
	@Test(dataProvider = "getLoginData")
	@BindingPriority(value = 3)
	private void doLogin(String username, String pwd) {
		HomePage homepage = page.getInstance(LoginPage.class).doLogin(username, pwd);
     //String headerHome = homepage.getHomePageHeader();
     //System.out.println(headerHome);
     //Assert.assertEquals(headerHome, "Getting started with HubSpot");
	}

}
