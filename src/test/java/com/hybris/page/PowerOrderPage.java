package com.hybris.page;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hybris.page.base.Page;

@Page
public class PowerOrderPage {

	@Autowired
	private WebDriver webDriver;
	
	public PowerOrderPage() {

//			if (!webDriver.getTitle().startsWith("Checkout")) {
//				// We are on the wrong page
//				throw new IllegalStateException("This is not the order page");
//			}
		}
}
