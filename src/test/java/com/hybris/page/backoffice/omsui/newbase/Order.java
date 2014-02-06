package com.hybris.page.backoffice.omsui.newbase;




public abstract class Order extends OMSTemplate implements MainPanel
{

	
	protected Detailable detailable;
	
	protected SearchComponent searchComponent;
	
	protected Listable listable;

	
	
	
	public Detailable getDetailable() {
		return detailable;
	}

	public void setDetailable(Detailable detailable) {
		this.detailable = detailable;
	}

	public SearchComponent getSearchComponent() {
		return searchComponent;
	}

	public void setSearchComponent(SearchComponent searchComponent) {
		this.searchComponent = searchComponent;
	}

	public Listable getListable() {
		return listable;
	}

	public void setListable(Listable listable) {
		this.listable = listable;
	}
	
	
}

