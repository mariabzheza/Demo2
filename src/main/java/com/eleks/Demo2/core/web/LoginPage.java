package com.eleks.Demo2.core.web;

import org.openqa.selenium.WebDriver;

public class LoginPage extends PagesHelper {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
		if(!"!!!!!!!!!!!!".equals(driver.getTitle())) {
			throw new IllegalStateException("This is not the LoginIntoMailAccount page!");
		}
	}
	
	
}
