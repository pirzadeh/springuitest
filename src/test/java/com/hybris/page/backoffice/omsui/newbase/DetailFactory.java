package com.hybris.page.backoffice.omsui.newbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DetailFactory {

	@Autowired
	private  DeliveryDetail deliveryDetail;

	public  Detailable getDeliveryDetail() {
		return deliveryDetail;
	}

	
}
