package com.hybris.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.hybris.page.base.Page;
import com.hybris.page.base.PageObject;

@Page
public class Site extends PageObject
{
	@Value("${BASE_URL}")
	private String baseURL;
	
	@Autowired
	private PowerHome powerHome; 
	
	public PowerHome gotoPowerHome()
	{
		getDriver().get(baseURL);
		getDriver().manage().window().maximize();
		return powerHome;
	 }
}
