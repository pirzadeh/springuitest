package com.hybris.page;

import org.springframework.beans.factory.annotation.Autowired;

import com.hybris.page.base.Page;
import com.hybris.page.base.PageObject;

@Page
public class Site extends PageObject
{
	
	@Autowired
	private PowerHome powerHome; 
	
	public PowerHome gotoPowerHome()
	{
		getDriver().get("http://powertools.dev-com4-2.yrdrt.fra.hybris.com:9001/yb2bacceleratorstorefront/");
		getDriver().manage().window().maximize();
		return powerHome;
	 }
}
