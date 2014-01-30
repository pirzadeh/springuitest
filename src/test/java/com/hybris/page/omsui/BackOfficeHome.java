package com.hybris.page.omsui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybris.page.b2b.PowerSearchResultsPage;
import com.hybris.page.base.Page;
import com.hybris.page.base.PageObject;

@Page
public class BackOfficeHome extends PageObject{

	@Autowired
	private BackOfficeLogin powerLogin;
	
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

	public BackOfficeLogin login() {

		loginLink.click();

		return powerLogin;

	}
}
