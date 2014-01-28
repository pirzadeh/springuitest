package com.hybris.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import com.hybris.page.base.Page;
import com.hybris.page.base.PageObject;

@Page
public class PowerViewCartPage extends PageObject{

	@Autowired
	private PowerLoginPage powerLoginPage;

	@FindBy(xpath = "//*[contains(@href,'cart/checkout')]")
	@CacheLookup
	protected WebElement checkoutLink;

	public PowerLoginPage checkoutCart() {

		checkoutLink.click();

		return powerLoginPage;
	}


}
