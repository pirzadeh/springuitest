package com.hybris.page.backoffice.omsui.newbase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hybris.page.base.Page;
import com.hybris.page.base.PageObject;


@Page
public class LeftMenu extends PageObject{

	@FindBy(xpath = ".//*[@title='Orders']")
	private WebElement orders;
	@FindBy(xpath = ".//*[@title='For Delivery']")
	private WebElement forDelivery;
	@FindBy(xpath = ".//*[@ytestid='Pick Up In Store']")
	private WebElement pickUp;
	@FindBy(xpath = ".//*[@ytestid='All Orders']")
	private WebElement allOrders;
	@FindBy(xpath = ".//*[@title='Stockroom Locations']")
	private WebElement stockroom;
	@FindBy(xpath = ".//*[@ytestid='node.id.oms.location']")
	private WebElement stockroomLocations;
	@FindBy(xpath = ".//*[@ytestid='node.id.oms.bin']")
	private WebElement bins;
	@FindBy(xpath = ".//*[@ytestid='Imports']")
	private WebElement imports;
	
	public WebElement getOrders() {
		findel(orders);
		return orders;
	}
	public WebElement getForDelivery() {
		findel(forDelivery);
		return forDelivery;
	}
	public WebElement getPickUp() {
		return pickUp;
	}
	public WebElement getAllOrders() {
		return allOrders;
	}
	public WebElement getStockroom() {
		return stockroom;
	}
	public WebElement getStockroomLocations() {
		return stockroomLocations;
	}
	public WebElement getBins() {
		return bins;
	}
	public WebElement getImports() {
		return imports;
	}

}

