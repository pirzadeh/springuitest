package com.hybris.test.smoke;

import org.junit.Assert;
import static org.fest.assertions.Assertions.assertThat;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

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

	@Value("${SEARCH_TERM}")
	private String searchTerm;

	@Value("${PRODUCT_SELECTED}")
	private String productSelected;

	@Value("${POWERTOOLS_USERNAME}")
	private String username;

	@Value("${POWERTOOLS_PASSWORD}")
	private String password;

	@Autowired
	private Site site;

	@Autowired
	private WebDriver webDriver;
	private String currentPage;  
	private String currentTitle; 

	@Autowired
	private WebDriverWait letsWait;

	@Test
	@Category({ SmokeTests.class, LoginFeature.class })
	public void testHomePageSearch() {

		System.out.println("1");

		// Given I am on the Hybris home page
		PowerHome homePage = site.gotoPowerHome();
		// Assert.assertTrue(driver.getCurrentUrl().contains("/search?text="));
		// When I enter "drill" on the page and click on search button
		PowerSearchResultsPage searchResultsPage = homePage
				.searchFor(searchTerm);
		// Then I should navigate to search results page
		currentPage = webDriver.getCurrentUrl();
		assertThat(currentPage).contains("/search?text=");

		//Assert.assertTrue(webDriver.getCurrentUrl().contains("/search?text="));

		PowerProductDetailsPage productDetailsPage = searchResultsPage
				.selectProduct(productSelected);
		currentPage = webDriver.getCurrentUrl();
		assertThat(currentPage).contains("Open-Catalogue");
		//Assert.assertTrue(webDriver.getCurrentUrl().contains("Open-Catalogue"));

		productDetailsPage = productDetailsPage.addProductToCart();
		currentPage = webDriver.getCurrentUrl();
		assertThat(currentPage).contains("Open-Catalogue");
		//Assert.assertTrue(webDriver.getCurrentUrl().contains("Open-Catalogue"));

		//WebDriverWait wait = new WebDriverWait(webDriver, 120);
		letsWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addToCartButton']")));

		PowerViewCartPage viewCartPage = productDetailsPage
				.checkoutFromMinicart();
		currentTitle = webDriver.getTitle();
		assertThat(currentTitle).startsWith("Your Shopping Cart");
		//Assert.assertTrue(webDriver.getTitle().startsWith("Your Shopping Cart"));

		PowerLoginPage loginPage = viewCartPage.checkoutCart();
		loginPage = loginPage.typeUsername(username);
		loginPage = loginPage.typePassword(password);
		PowerOrderPage orderPage = loginPage.loginAndCheckout();
		currentTitle = webDriver.getTitle();
		assertThat(currentTitle).startsWith("Checkout");
		//Assert.assertTrue(webDriver.getTitle().startsWith("Checkout"));

	}

}
