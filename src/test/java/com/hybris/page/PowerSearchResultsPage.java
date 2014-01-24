package com.hybris.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hybris.page.base.Page;

@Page
public class PowerSearchResultsPage {

	@Autowired
	private WebDriver webDriver;

	@Autowired
	private PowerProductDetailsPage powerProductDetailsPage;

	@FindBy(xpath = "a[contains(@class,'productMainLink')]")
	protected WebElement productLink;

	public WebElement getProductLink() {
		return productLink;
	}

	public void setProductLink(WebElement productLink) {
		this.productLink = productLink;
	}

	public PowerSearchResultsPage() {

//		if (!webDriver.getCurrentUrl().contains("/search?text=")) {
//			// We are on the wrong page
//			throw new IllegalStateException(
//					"This is not the search results page");
//		}
	}

	public PowerProductDetailsPage selectProduct(String text) {
		getProductLink(text);
		productLink.click();

		return powerProductDetailsPage;
	}
	
	private void getProductLink(String text) {
		productLink = webDriver
				.findElement(By
						.xpath("//a[contains(@class,'productMainLink') and contains(@href,'"
								+ text + "')]"));
	}
}
