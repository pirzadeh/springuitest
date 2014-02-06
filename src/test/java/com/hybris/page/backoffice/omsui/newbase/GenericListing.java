package com.hybris.page.backoffice.omsui.newbase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class GenericListing extends OMSTemplate implements Listable
{
	
	
	
	@FindBy(xpath = ".//*[@ytestid='orderId']")
	private WebElement firstItemInResults;
	
	public WebElement getFirstItemInResults() {
		findel(firstItemInResults);
		return firstItemInResults;
	}
	public Detailable selectFirst() {
		getFirstItemInResults().click();
		return getMainPanel().getDetailable();
	}

	
	

}

