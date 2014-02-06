package com.hybris.page.backoffice.omsui.newbase;

import org.springframework.beans.factory.annotation.Autowired;

import com.hybris.page.backoffice.base.BackofficeTopNavigation;
import com.hybris.page.base.PageObject;



public abstract class OMSTemplate extends PageObject
{

	@Autowired
	public LeftMenu leftMenu;
	
	public static MainPanel mainPanel;
	
	@Autowired
	public BackofficeTopNavigation topNavigation;

	
	
	
	
	public LeftMenu getLeftMenu() {
		return leftMenu;
	}

	public void setLeftMenu(LeftMenu leftMenu) {
		this.leftMenu = leftMenu;
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public BackofficeTopNavigation getTopNavigation() {
		return topNavigation;
	}

	public void setTopNavigation(BackofficeTopNavigation topNavigation) {
		this.topNavigation = topNavigation;
	}
	
	/////////////////////////////

	
	public MainPanel gotoForDelivery (){
		
		gotoOrders().getLeftMenu().getForDelivery().click();
		return getMainPanel();
		
	}
	public OMSTemplate gotoOrders (){
		getLeftMenu().getOrders().click();
		return this;
	}
	public MainPanel gotoPickUp (){
		getLeftMenu().getPickUp().click();
		return mainPanel;
		
	}
	
	public MainPanel gotoAllOrders (){
		getLeftMenu().getAllOrders().click();
		return mainPanel;
		
	}

}

