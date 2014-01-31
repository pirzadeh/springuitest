package com.hybris.page.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class PageObject {

	@Autowired
	private WebDriver driver;

	@Autowired
	private WebDriverWait letswait;
	
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
	public WebElement findel(By locator){
	letswait.until(ExpectedConditions.elementToBeClickable(locator));
	WebElement element = getDriver().findElement(locator);
	return element;
	}
	
	public void findel(WebElement element) {
		letswait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
}
