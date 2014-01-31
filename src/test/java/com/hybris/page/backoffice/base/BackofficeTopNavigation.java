package com.hybris.page.backoffice.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybris.page.backoffice.commercesearch.CommerceSearch;
import com.hybris.page.backoffice.omsadmin.OMSAdmin;
import com.hybris.page.backoffice.omsui.OMS;
import com.hybris.page.base.Page;
import com.hybris.page.base.PageObject;

@Page
public class BackofficeTopNavigation extends PageObject{
	
	@FindBy(xpath = ".//*[@title='Commerce Search']")
	private WebElement commerceSearchButton;
	
	@FindBy(xpath = ".//*[@title='OMS']")
	private WebElement omsButton;
	
	@FindBy(xpath = ".//*[@title='OMS Admin']")
	private WebElement omsAdminButton;

	@Autowired
	private CommerceSearch commerceSearch;
	@Autowired
	private OMS oms;
	@Autowired
	private OMSAdmin omsAdmin;
	
	
	
	public CommerceSearch goToCommerceSearch (){
		commerceSearchButton.click();
		return commerceSearch;
		
	}
	
	public OMS gotoOMS(){
		findel(omsButton);
		omsButton.click();
		return oms;
	}
	
	

	public OMSAdmin gotoOMSAdmin(){
		omsAdminButton.clear();
		return omsAdmin;
	}
}
