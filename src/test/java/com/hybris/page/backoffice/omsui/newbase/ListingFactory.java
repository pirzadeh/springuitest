package com.hybris.page.backoffice.omsui.newbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListingFactory {

	@Autowired
	private  DeliveryListing deliveryListing;

	public  Listable getDeliveryListing() {
		return deliveryListing;
	}

	
}
