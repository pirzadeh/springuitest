package com.hybris.page.backoffice.omsui;


import org.springframework.beans.factory.annotation.Autowired;

import com.hybris.page.backoffice.omsui.base.ForDeliveryOrderDetails;
import com.hybris.page.backoffice.omsui.base.Orders;
import com.hybris.page.base.Page;

@Page
public class ForDelivery extends Orders{

	@Autowired
	private ForDeliveryOrderDetails deliveryOrderDetails;
	
	public ForDeliveryOrderDetails getDeliveryOrderDetails() {
		return deliveryOrderDetails;
	}

	public ForDelivery confirmShipment() {
		getDeliveryOrderDetails().confirm();
		return this;
		
	}
}
