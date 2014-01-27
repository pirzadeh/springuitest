package com.hybris.test.smoke;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Assert;

import com.hybris.page.PowerHome;
import com.hybris.page.PowerLoginPage;
import com.hybris.page.PowerOrderPage;
import com.hybris.page.PowerProductDetailsPage;
import com.hybris.page.PowerSearchResultsPage;
import com.hybris.page.PowerViewCartPage;
import com.hybris.page.Site;
import com.hybris.test.base.SeleniumTestCase;
import com.hybris.test.categories.LoginFeature;
import com.hybris.test.categories.SmokeTests;

public class TestSmoke extends SeleniumTestCase {

	@Autowired
	private Site site;

	@Autowired
	private WebDriver webDriver;

	public void setDriver(WebDriver driver) {
		this.webDriver = driver;
	}

	private static final String SEARCH_TERM = "drill";

	@Test
	@Category({ SmokeTests.class, LoginFeature.class })
	public void testHomePageSearch() {

		System.out.println("1");

		// Given I am on the Hybris home page
		PowerHome homePage = site.gotoPowerHome();
		// Assert.assertTrue(driver.getCurrentUrl().contains("/search?text="));
		// When I enter "drill" on the page and click on search button
		PowerSearchResultsPage searchResultsPage = homePage
				.searchFor(SEARCH_TERM);
		// Then I should navigate to search results page
		Assert.assertTrue(webDriver.getCurrentUrl().contains("/search?text="));

		PowerProductDetailsPage productDetailsPage = searchResultsPage
				.selectProduct("Cordless-drill-driver-2006");
		Assert.assertTrue(webDriver.getCurrentUrl().contains("Open-Catalogue"));

		productDetailsPage = productDetailsPage.addProductToCart();
		Assert.assertTrue(webDriver.getCurrentUrl().contains("Open-Catalogue"));

		WebDriverWait wait = new WebDriverWait(webDriver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//*[@id='addToCartButton']")));

		PowerViewCartPage viewCartPage = productDetailsPage
				.checkoutFromMinicart();
		Assert.assertTrue(webDriver.getTitle().startsWith("Your Shopping Cart"));

		PowerLoginPage loginPage = viewCartPage.checkoutCart();
		loginPage = loginPage.typeUsername("anthony.lombardi@rustic-hw.com");
		loginPage = loginPage.typePassword("12341234");
		PowerOrderPage orderPage = loginPage.loginAndCheckout();
		Assert.assertTrue(webDriver.getTitle().startsWith("Checkout"));

	}

}
