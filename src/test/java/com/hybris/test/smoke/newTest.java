package com.hybris.test.smoke;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hybris.Beansample;
import com.hybris.page.PowerHome;
import com.hybris.page.Site;
import com.hybris.test.base.SeleniumTestCase;

public class newTest extends SeleniumTestCase{

	@Autowired
	private Beansample beansam;
	
	@Autowired
	private Site site;
	
	private WebDriver  webDriver;
	
	@Test
	public void testHello(){
		System.out.println(beansam.sayHello());
//		webDriver.get("http://google.com");
		PowerHome homePage = site.gotoPowerHome();
		
	}
}
