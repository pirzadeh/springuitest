package com.hybris.page.backoffice;

import org.springframework.beans.factory.annotation.Autowired;
import com.hybris.page.base.Page;
import com.hybris.page.base.PageObject;

@Page
public class BackOfficeDriver extends PageObject
{
	private String baseURL = "http://qa-acc1.yrdanura.fra.hybris.com:9001/backoffice/";
	
	@Autowired
	private BackOfficeLogin backOfficeLogin; 
	
	public BackOfficeLogin gotoBackoffice()
	{
		getDriver().get(baseURL);
		getDriver().manage().window().maximize();
		return backOfficeLogin;
	 }
}
