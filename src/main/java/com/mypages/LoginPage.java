/**
 * 
 */
package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author sambasivarao
 *
 */
public class LoginPage extends BasePage {
	private By emailId = By.id("username");
	private By password = By.id("password");
	private By loginbutton = By.id("loginBtn");
	private By header = By.xpath("//*[@id=\"hs-login\"]/div[1]/i18n-string");

	// page locators
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Public getters
	/**
	 * @return the emailId
	 */
	public WebElement getEmailId() {
		return getElement(emailId);
	}

	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return getElement(password);
	}

	/**
	 * @return the loginbutton
	 */
	public WebElement getLoginbutton() {
		return getElement(loginbutton);
	}

	/**
	 * @return the header
	 */
	public WebElement getHeader() {
		return getElement(header);
	}

	public String getLoginPageTitle() {
		return getPageTitle();

	}

	public String getLoginPageHeader() {
		return getPageHeader(header);

	}

	public HomePage doLogin(String username, String pwd) {
		
		getEmailId().sendKeys(username);
		getPassword().sendKeys(pwd);
		getLoginbutton().click();

		return getInstance(HomePage.class);

	}
}
