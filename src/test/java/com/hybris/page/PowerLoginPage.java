package com.hybris.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import com.hybris.page.base.Page;
import com.hybris.page.base.PageObject;

@Page
public class PowerLoginPage extends PageObject{


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

}
