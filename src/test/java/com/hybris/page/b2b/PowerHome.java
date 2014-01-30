package com.hybris.page.b2b;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import com.hybris.page.base.Page;
import com.hybris.page.base.PageObject;

@Page
public class PowerHome extends PageObject{

	@Autowired
	private PowerLoginPage powerLogin;
	
	@Autowired
	private	PowerSearchResultsPage powerSearchResultPage;


	private WebElement search;
	private WebElement search_form;

	@FindBy(how = How.XPATH, using = "//a[contains(@href,'login')]")
	private WebElement loginLink;
	
	
	public PowerSearchResultsPage searchFor(String text) {

		search.sendKeys(text);
		search_form.submit();

		return powerSearchResultPage;
	}

	public PowerLoginPage login() {

		loginLink.click();

		return powerLogin;

	}
}
