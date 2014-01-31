package com.hybris.page.backoffice.omsui.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.hybris.page.backoffice.base.BackofficeTemplate;
import com.hybris.page.backoffice.omsui.OMS;
import com.hybris.page.base.Page;

@Page
public class OMSTemplate extends BackofficeTemplate{
	
	@Autowired
	private OMSLeftMenu leftMenu;
	
	@Autowired
	private Orders orders;

	public OMSLeftMenu getLeftMenu() {
		return leftMenu;
	}
	
	public Orders gotoForDelivery (){
		gotoOrders().getLeftMenu().getForDelivery().click();
		return orders;
		
	}
	public OMSTemplate gotoOrders (){
		getLeftMenu().getOrders().click();
		return this;
	}
	public Orders gotoPickUp (){
		getLeftMenu().getPickUp().click();
		return orders;
		
	}
	
	public Orders gotoAllOrders (){
		getLeftMenu().getAllOrders().click();
		return orders;
		
	}
}
