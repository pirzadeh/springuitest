package com.hybris.test.omsui;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;


import com.hybris.page.backoffice.BackOfficeDriver;
import com.hybris.page.backoffice.BackOfficeHome;
import com.hybris.page.backoffice.BackOfficeLogin;
import com.hybris.page.backoffice.omsui.OMS;
import com.hybris.test.base.SeleniumTestCase;


public class OMSUITest extends SeleniumTestCase {


	@Autowired
	private BackOfficeDriver testdriver;

	@Autowired
	private WebDriverWait letsWait;

	@SuppressWarnings("unused")
	@Test
	public void testHomePageSearch() {

		// Given I am on the Hybris home page
		BackOfficeLogin backOfficeLogin = testdriver.gotoBackoffice();

		BackOfficeHome backOfficeHome = backOfficeLogin.login("admin", "nimda");
		//letsWait.until(ExpectedConditions.titleContains("hybris Backoffice"));
		//assertThat(backOfficeHome.getTitle()).contains("hybris Backoffice");

		OMS oms = backOfficeHome.getTopNavigation().gotoOMS();
	}

}
