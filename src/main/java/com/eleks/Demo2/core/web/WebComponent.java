package com.eleks.Demo2.core.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class WebComponent extends Components {

	protected final By findByMethod;
	
	public WebComponent(WebDriver driver, By findByMethod) {
		super(driver);
		this.findByMethod = findByMethod;
	}
	
	protected WebElement getWebElement() {
		return driver.findElement(findByMethod);
	}

}
