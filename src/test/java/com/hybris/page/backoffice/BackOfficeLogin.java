package com.hybris.page.backoffice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import com.hybris.page.base.Page;
import com.hybris.page.base.PageObject;

@Page
public class BackOfficeLogin extends PageObject{


	@Autowired
	private BackOfficeHome backOfficeHome;

		
	private WebElement j_username;

	private WebElement j_password;

	private WebElement lgBtn;


	public BackOfficeLogin typeUsername(String username) {

		j_username.sendKeys(username);

		return this;
	}

	public BackOfficeLogin typePassword(String password) {
		// This is the only place that "knows" how to enter a password
		j_password.sendKeys(password);

		return this;
	}

	public BackOfficeHome login(String username, String password) {

		typeUsername(username);
		typePassword(password);
		lgBtn.submit();
		return backOfficeHome;
	}

}
