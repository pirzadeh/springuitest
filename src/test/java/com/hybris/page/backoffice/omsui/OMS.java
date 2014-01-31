package com.hybris.page.backoffice.omsui;

import org.springframework.beans.factory.annotation.Autowired;

import com.hybris.page.backoffice.omsui.base.OMSTemplate;
import com.hybris.page.base.Page;

@Page
public class OMS extends OMSTemplate{
	
@Autowired
private ForDelivery forDelivery;

	public ForDelivery searchForDelivery(String value, String sortby) {
		gotoForDelivery().getOrdersSearch().search(value, sortby);
		return forDelivery;
	}

	public ForDelivery searchForDelivery(String value) {
		searchForDelivery(value,"id");
		return forDelivery;
	}
}
