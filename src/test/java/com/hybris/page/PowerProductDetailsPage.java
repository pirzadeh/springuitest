package com.hybris.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import com.hybris.page.base.Page;
import com.hybris.page.base.PageObject;

@Page
public class PowerProductDetailsPage extends PageObject{


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

}
