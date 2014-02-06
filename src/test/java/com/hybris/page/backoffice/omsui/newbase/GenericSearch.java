package com.hybris.page.backoffice.omsui.newbase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class GenericSearch extends OMSTemplate  implements SearchComponent
{



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
	
	public Listable search (String value, String sortby){
		getSearchInput().sendKeys(value);
		sortBy(sortby);
		getSearchButton().click();
		return getMainPanel().getListable();
		
	}
	
	public SearchComponent sortBy(String sortby) {
		if (sortby.equals("LastName")){
			getByLastNameRadio().click();
		}
		else{
			getByOrderIdRadio().click();
		}
		return getMainPanel().getSearchComponent();
	}
	
	public Listable search (String value){
		search (value,"id");
		return getMainPanel().getListable();
	}
	
	public SearchComponent expandSeachDetails() {
		// TODO Auto-generated method stub
		return null;
	}
}

