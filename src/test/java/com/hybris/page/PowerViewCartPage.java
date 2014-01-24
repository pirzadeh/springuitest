package com.hybris.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hybris.page.base.Page;

@Page
public class PowerViewCartPage {

	@Autowired
	private WebDriver webDriver;

	@Autowired
	private PowerLoginPage powerLoginPage;

	@FindBy(xpath = "//*[contains(@href,'cart/checkout')]")
	@CacheLookup
	protected WebElement checkoutLink;

	public PowerViewCartPage() {

//		// Check that we're on the right page.
//		if (!webDriver.getTitle().startsWith("Your Shopping Cart")) {
//			// We are on the wrong page
//			throw new IllegalStateException("This is not the view cart page");
//		}
	}

	public PowerLoginPage checkoutCart() {

		System.out.println("Here ==> " + webDriver);
		checkoutLink.click();

		return powerLoginPage;
	}


}
