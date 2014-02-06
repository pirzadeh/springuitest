package com.hybris.test.omsui;

import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;


import com.hybris.page.backoffice.BackOfficeDriver;
import com.hybris.page.backoffice.BackOfficeHome;
import com.hybris.page.backoffice.BackOfficeLogin;
import com.hybris.page.backoffice.omsui.OMS;
import com.hybris.page.backoffice.omsui.newbase.DeliveryDetail;
import com.hybris.test.base.SeleniumTestCase;


public class OMSUITest extends SeleniumTestCase {


	@Autowired
	private BackOfficeDriver testdriver;

	@Autowired
	private WebDriverWait letsWait;


	private OMS gotoOMS (){
		// Given I am on the Hybris home page
		BackOfficeLogin backOfficeLogin = testdriver.gotoBackoffice();
		BackOfficeHome backOfficeHome = backOfficeLogin.login("admin", "nimda");
		OMS oms = backOfficeHome.getTopNavigation().gotoOMS();
		return oms;
	}


	@Test
	public void testSearch() {

		gotoOMS().searchForDelivery("1386282955000").selectFirst().confirm();
		
	}

}
