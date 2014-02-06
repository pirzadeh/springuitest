package com.hybris.page.backoffice.omsui.newbase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hybris.page.base.Page;


@Page
public class DeliveryDetail extends GenericDetail implements Detailable 
{
	
	@FindBy(xpath = ".//*[text()[contains(normalize-space(.),'Pick Slip')]]")
	private WebElement pickSlipButton;
	@FindBy(xpath = ".//*[text()[contains(normalize-space(.),'Confirm')]]")
	private WebElement confirmButton;
	@FindBy(xpath = ".//*[text()[contains(normalize-space(.),'Yes')]]")
	private WebElement yesConfirmButton;
	@FindBy(xpath = ".//*[text()[contains(normalize-space(.),'OK')]]")
	private WebElement OkYesConfirmButton;
	
	public WebElement getOkYesConfirmButton() {
		findel(OkYesConfirmButton);
		return OkYesConfirmButton;
	}


	public WebElement getPickSlipButton() {
		findel(pickSlipButton);
		return pickSlipButton;
	}


	public WebElement getConfirmButton() {
		findel(confirmButton);
		return confirmButton;
	}


	public WebElement getYesConfirmButton() {
		findel(yesConfirmButton);
		return yesConfirmButton;
	}


	public Detailable pack() {
		// TODO : to implement	
		return getMainPanel().getDetailable();
	}
	
	
	public Detailable ship() {
		// TODO : to implement	
		return getMainPanel().getDetailable();
	}
	
	public Detailable confirm() {
		getConfirmButton().click();
		getYesConfirmButton().click();
		getOkYesConfirmButton().click();
		return getMainPanel().getDetailable();
	}
	
		
	public void decline() {
		// TODO : to implement	
	}


	@Override
	public Detailable pick() {
		getPickSlipButton().click();
		return getMainPanel().getDetailable();
	}
	
}

