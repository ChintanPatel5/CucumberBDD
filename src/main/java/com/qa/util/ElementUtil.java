package com.qa.util;

import org.openqa.selenium.By;

import com.qa.factory.DriverFactory;

public class ElementUtil {

	public static void doclick(By element) {
		DriverFactory.getDriver().findElement(element).click();
	}
}
