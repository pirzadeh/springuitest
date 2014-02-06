package com.hybris.page.backoffice.omsui.newbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchFactory {

	@Autowired
	private  DeliverySearch deliverySearch;

	public  SearchComponent getDeliverySearch() {
		return deliverySearch;
	}

	
}
