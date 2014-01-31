package com.hybris.page.backoffice.omsui.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hybris.page.base.Page;
import com.hybris.page.base.PageObject;

@Page
public class ForDeliveryOrderDetails extends PageObject{
	
	@FindBy(xpath = ".//*[@ytestid='com_hybris_oms_actions_ConfirmShipmentAction']")
	private WebElement confirmButton;
		
	
	public WebElement getConfirmButton() {
		findel(confirmButton);
		return confirmButton;
	}

	public ForDeliveryOrderDetails confirm (){
		getConfirmButton().click();
		return this;
		
	}
	
}