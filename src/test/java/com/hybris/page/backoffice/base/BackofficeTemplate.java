package com.hybris.page.backoffice.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.hybris.page.base.Page;
import com.hybris.page.base.PageObject;

@Page
public class BackofficeTemplate extends PageObject{

	@Autowired
	private BackofficeTopNavigation topNavigation;

	public BackofficeTopNavigation getTopNavigation() {
		return topNavigation;
	}
	
}
