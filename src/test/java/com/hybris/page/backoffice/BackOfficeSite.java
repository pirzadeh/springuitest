package com.hybris.page.backoffice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.hybris.page.base.Page;
import com.hybris.page.base.PageObject;

@Page
public class BackOfficeSite extends PageObject
{
	private String baseURL = "http://dev-xc2-2.yrdrt.fra.hybris.com:9001/backoffice/login.zul";
	
	@Autowired
	private BackOfficeLogin backOfficeLogin; 
	
	public BackOfficeLogin gotoPowerHome()
	{
		getDriver().get(baseURL);
		getDriver().manage().window().maximize();
		return backOfficeLogin;
	 }
}
