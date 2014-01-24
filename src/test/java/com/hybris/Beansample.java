package com.hybris;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hybris.page.base.Page;

@Page
public class Beansample {
	
	@Autowired
	private WebDriver webDriver;
	public String sayHello	(){
		return "Hello  ==>"+webDriver;
		
	}

}
