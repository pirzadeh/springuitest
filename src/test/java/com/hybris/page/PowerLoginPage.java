package com.hybris.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.hybris.page.base.Page;

@Page
public class PowerLoginPage {

	@Autowired
	private WebDriver webDriver;
	
	@Autowired
	private PowerOrderPage powerOrderPage;

		
	private WebElement j_username;

		
	private WebElement j_password;

	@FindBy(xpath = "//form[@id='loginForm']/descendant::button")
	protected WebElement loginAndCheckoutButtonLocator;


	public PowerLoginPage typeUsername(String username) {

		j_username.sendKeys(username);

		return this;
	}

	public PowerLoginPage typePassword(String password) {
		// This is the only place that "knows" how to enter a password
		j_password.sendKeys(password);

		return this;
	}

	public PowerOrderPage loginAndCheckout() {

		loginAndCheckoutButtonLocator.submit();
		return powerOrderPage;
	}

	public PowerLoginPage() {

//		// Check that we're on the right page.
//		if (!webDriver.getCurrentUrl().contains("login")) {
//			// We are on the wrong page
//			throw new IllegalStateException("This is not the login page");
//		}
	}

}
