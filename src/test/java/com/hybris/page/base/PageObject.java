package com.hybris.page.base;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class PageObject {
	
	@Autowired
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		PageObject.driver = driver;
	}
	
	
}
