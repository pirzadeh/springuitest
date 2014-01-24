package com.hybris.test.base;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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
		Map<String, Object> scopes = new HashMap<>();
		scopes.put("test", testScope());
		scopeConfigurer.setScopes(scopes);
		return scopeConfigurer;
	}

	@Bean
	@Scope("test")
	public WebDriver webDriver() {
		return new FirefoxDriver();
	}
}