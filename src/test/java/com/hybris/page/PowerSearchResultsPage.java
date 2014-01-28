package com.hybris.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import com.hybris.page.base.Page;
import com.hybris.page.base.PageObject;

@Page
public class PowerSearchResultsPage extends PageObject{

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


	public PowerProductDetailsPage selectProduct(String text) {
		getProductLink(text);
		productLink.click();

		return powerProductDetailsPage;
	}

	private void getProductLink(String text) {
		productLink = getDriver()
				.findElement(By
						.xpath("//a[contains(@class,'productMainLink') and contains(@href,'"
								+ text + "')]"));
	}
}
