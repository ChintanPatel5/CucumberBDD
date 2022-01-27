package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;

	private By menuItems = By.xpath("//nav[@class='bm-item-list']/a");
	private By menuIcon= By.id("react-burger-menu-btn");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}

	public int getMenuSectionCount() {
		return driver.findElements(menuItems).size();
	}

	public void clickMenuIcon() {
		driver.findElement(menuIcon).click();
		
	}
	public List<String> getMenuSectionsList() {

		List<String> menuList = new ArrayList<>();
		List<WebElement> menuHeaderList = driver.findElements(menuItems);

		for (WebElement e : menuHeaderList) {
			String text = e.getText();
			System.out.println(text);
			menuList.add(text);
		}

		return menuList;

	}



}
