package com.hybris.page.base;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.hybris.test.base.SeleniumTestCaseContext;

@ComponentScan(basePackages = {"com.hybris.page.base", "com.hybris.page", "org.openqa.selenium"})
@Component
public class PageBeanPostProcessor implements BeanPostProcessor {

	@Autowired
	private WebDriver driver;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean.getClass().isAnnotationPresent(Page.class)) {
			PageFactory.initElements(driver, bean);
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
}