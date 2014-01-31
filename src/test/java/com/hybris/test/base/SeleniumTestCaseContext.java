package com.hybris.test.base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages = "com.hybris")
public class SeleniumTestCaseContext {

	@Bean
	public static TestScope testScope() {
		return new TestScope();
	}

	@Bean
	public static CustomScopeConfigurer customScopeConfigurer() {
		CustomScopeConfigurer scopeConfigurer = new CustomScopeConfigurer();
		Map<String, Object> scopes = new HashMap<String, Object>();
		scopes.put("test", testScope());
		scopeConfigurer.setScopes(scopes);
		return scopeConfigurer;
	}

	@Bean
	@Scope("test")
	public WebDriver webDriver() {
		WebDriver driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(100,TimeUnit.SECONDS);
		return driver;
	}

	@Bean
	@Scope("test")
	public WebDriverWait letsWait() {
		return new WebDriverWait(webDriver(), 120);
	} 

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {

		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		if (null != System.getProperty("Profile")) {

			propertySourcesPlaceholderConfigurer
			.setLocation(new ClassPathResource(
					"environment_"+System.getProperty("Profile")+".properties"));

		} else {

			propertySourcesPlaceholderConfigurer
			.setLocation(new ClassPathResource(
					"environment_local.properties"));

		}

		return propertySourcesPlaceholderConfigurer;
	}

}