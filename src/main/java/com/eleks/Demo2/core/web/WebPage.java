package com.eleks.Demo2.core.web;

import org.openqa.selenium.WebDriver;

public abstract class WebPage extends Components {
	
	public WebPage(WebDriver driver) {
		super(driver);
	}
	
	public abstract Components load();
	
	public Components loadAndWaitUntilAwailable(){
		load();
		return waitUntilAwailable();
	}
	
}
