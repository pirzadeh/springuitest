package com.hybris.page.backoffice.omsui.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hybris.page.base.Page;
import com.hybris.page.base.PageObject;

@Page
public class OrdersSearch extends PageObject{
	
	@FindBy(xpath = ".//*[@class='yw-search-box z-textbox']")
	private WebElement searchInput;
	@FindBy(xpath = ".//*[@title='Search']")
	private WebElement searchButton;
	@FindBy(xpath = ".//*[@value='orderId']")
	private WebElement byOrderIdRadio;
	@FindBy(xpath = ".//*[@value='lastName']")
	private WebElement byLastNameRadio;
	
	public WebElement getSearchInput() {
		findel(searchInput);
		return searchInput;
	}
	public WebElement getSearchButton() {
		findel(searchButton);
		return searchButton;
	}
	public WebElement getByOrderIdRadio() {
		findel(byOrderIdRadio);
		return byOrderIdRadio;
	}
	public WebElement getByLastNameRadio() {
		findel(byLastNameRadio);
		return byLastNameRadio;
	}
	
	public OrdersSearch search (String value, String sortby){
		getSearchInput().sendKeys(value);
		setSort(sortby);
		getSearchButton().click();
		return this;
		
	}
	
	public OrdersSearch setSort(String sortby) {
		if (sortby.equals("LastName")){
			getByLastNameRadio().click();
		}
		else{
			getByOrderIdRadio().click();
		}
		return this;
	}
	
	public OrdersSearch search (String value){
		search (value,"id");
		return this;
	}
	
}
