package com.hybris.page;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.hybris.page.base.Page;

@Page
public class Site
{
	@Autowired
	private WebDriver webDriver;
	 
	@Autowired
	private PowerHome powerHome; 
	
	public PowerHome gotoPowerHome()
	{
		webDriver.get("http://powertools.dev-com4-2.yrdrt.fra.hybris.com:9001/yb2bacceleratorstorefront/");
		webDriver.manage().window().maximize();
		return powerHome;
	 }
}
