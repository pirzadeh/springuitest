package com.hybris.page.backoffice.omsui;

import org.springframework.beans.factory.annotation.Autowired;

import com.hybris.page.backoffice.omsui.newbase.Listable;
import com.hybris.page.backoffice.omsui.newbase.OMSTemplate;
import com.hybris.page.backoffice.omsui.newbase.PanelFactory;
import com.hybris.page.base.Page;

@Page
public class OMS extends OMSTemplate{

	@Autowired
	private PanelFactory panelFactory;
	

	public Listable searchForDelivery(String value) {
		
		setMainPanel(panelFactory.getForDelivery());
		gotoForDelivery().getSearchComponent().search(value);
		return getMainPanel().getListable();
	}

}
