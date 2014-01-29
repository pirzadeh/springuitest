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

		// When I enter "drill" on the page and click on search button
		PowerSearchResultsPage searchResultsPage = homePage.searchFor(searchTerm);
		// Then I should navigate to search results page
		currentPage = webDriver.getCurrentUrl();
		assertThat(currentPage).contains("/search?text=");

		// When I select a product from the search results
		PowerProductDetailsPage productDetailsPage = searchResultsPage.selectProduct(productSelected);
		// Then I should navigate to product details page
		currentPage = webDriver.getCurrentUrl();
		assertThat(currentPage).contains("Open-Catalogue");

		// When I add a product to cart
		productDetailsPage = productDetailsPage.addProductToCart();
		currentPage = webDriver.getCurrentUrl();
		// Then I should remain on the same page
		assertThat(currentPage).contains("Open-Catalogue");

		letsWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='addToCartButton']")));

		// When I checkout from the mini cart
		PowerViewCartPage viewCartPage = productDetailsPage.checkoutFromMinicart();
		currentTitle = webDriver.getTitle();
		// Then I should navigate to view cart page
		assertThat(currentTitle).startsWith("Your Shopping Cart");

		// When I checkout from the view cart page
		PowerLoginPage loginPage = viewCartPage.checkoutCart();
		// Then I shold be taken to the login page
		loginPage = loginPage.typeUsername(username);
		loginPage = loginPage.typePassword(password);
		// When I login and checkout
		PowerOrderPage orderPage = loginPage.loginAndCheckout();
		currentTitle = webDriver.getTitle();
		// Then I should navigate to the Order Placement Page
		assertThat(currentTitle).startsWith("Checkout");

	}

}
