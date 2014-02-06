package com.hybris.page.backoffice.omsui.newbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PanelFactory {

	@Autowired
	private ForDelivery forDelivery;
	@Autowired
	private DetailFactory detailFactory;
	@Autowired
	private ListingFactory listingFactory;
	@Autowired 
	private SearchFactory searchFactory;

	public  MainPanel getForDelivery() {
		forDelivery.setDetailable(detailFactory.getDeliveryDetail());
		forDelivery.setListable(listingFactory.getDeliveryListing());
		forDelivery.setSearchComponent(searchFactory.getDeliverySearch());
		return forDelivery;
	}

	
}
