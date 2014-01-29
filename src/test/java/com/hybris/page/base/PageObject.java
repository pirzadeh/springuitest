package com.hybris.page.base;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class PageObject {

	@Autowired
	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getURL() {
		return getDriver().getCurrentUrl();
	}

	public String getTitle() {
		return getDriver().getTitle();
	}

	public String getHandleToWindow() {
		return getDriver().getWindowHandle();
	}

}
