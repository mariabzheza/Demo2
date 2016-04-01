package com.eleks.Demo2.core.web;

import org.openqa.selenium.WebDriver;

public abstract class Components {
	
	protected WebDriver driver;
	
	public Components(WebDriver driver) {
		this.driver = driver;
	}
	
	public abstract boolean isAwailable();
	
	public Components waitUntilAwailable() {
		return new WaitingClass().forComponent((Components)this).toBeAwailable();
	}

}
