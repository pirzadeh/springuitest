package com.hybris.page.backoffice.omsui.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.hybris.page.base.Page;

@Page
public class Orders extends OMSTemplate{

	@Autowired
	private OrdersSearch ordersSearch;

	@Autowired
	private SearchResults results;
	
	public SearchResults getResults() {
		return results;
	}

	public OrdersSearch getOrdersSearch() {
		return ordersSearch;
	}
	
	public Orders search (String value, String sortby){
		getOrdersSearch().search(value, sortby);
		return this;
		
	}
	
	public Orders selectFirstItem (){
		getResults().getFirstItemInResults().click();
		return this;
		
	}
	
}
