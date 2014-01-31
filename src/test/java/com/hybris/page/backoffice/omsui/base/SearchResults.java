package com.hybris.page.backoffice.omsui.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hybris.page.base.Page;
import com.hybris.page.base.PageObject;

@Page
public class SearchResults extends PageObject{
	
	@FindBy(xpath = ".//*[@ytestid='orderId']")
	private WebElement firstItemInResults;
	
	public WebElement getFirstItemInResults() {
		findel(firstItemInResults);
		return firstItemInResults;
	}
	
	
}
