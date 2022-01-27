package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.ElementUtil;

public class LoginPage {

	private WebDriver driver;

	// 1. Locators
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By loginInButton = By.id("login-button");
	private By botLogo = By.className("bot_column");

	// 2. Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. PageAcions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPasswordLinkExists() {
		return driver.findElement(botLogo).isDisplayed();
	}

	public void enterUserName(String userName) {
		driver.findElement(username).sendKeys(userName);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickSignInButton() {
		//driver.findElement(signInButton).click();
		ElementUtil.doclick(loginInButton);
	}
	
	public HomePage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginInButton).click();
		return new HomePage(driver);
	}
}
