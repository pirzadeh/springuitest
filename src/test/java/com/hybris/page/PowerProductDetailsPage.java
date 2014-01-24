package com.hybris.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hybris.page.base.Page;

@Page
public class PowerProductDetailsPage {

	@Autowired
	 private WebDriver webDriver;
	 
	 @Autowired
	 private PowerViewCartPage powerViewCartPage;

	@CacheLookup
	private WebElement addToCartButton;

	@FindBy(xpath = "//a[contains(@href,'cart')]")
	@CacheLookup
	private WebElement checkoutLink;

	public WebElement getCheckoutLink() {
		return checkoutLink;
	}

	public PowerProductDetailsPage addProductToCart() {

		addToCartButton.click();

		return this;
	}

	public PowerViewCartPage checkoutFromMinicart() {

		checkoutLink.click();

		return powerViewCartPage;
	}

	public PowerProductDetailsPage() {

//		// Check that we're on the right page.
//		if (!webDriver.getCurrentUrl().contains("Open-Catalogue")) {
//			// We are on the wrong page
//			throw new IllegalStateException(
//					"This is not the product details page");
//		}
	}
}
