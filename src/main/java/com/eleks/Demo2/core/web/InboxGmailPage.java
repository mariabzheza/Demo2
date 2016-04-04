package com.eleks.Demo2.core.web;

import org.openqa.selenium.WebDriver;

public class InboxGmailPage extends PagesHelper {
	
	private WebDriver driver;
	
	public InboxGmailPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
		if( !driver.getTitle().contains("@gmail.com - Gmail")) {
			throw new IllegalStateException("This is not the Inbox page!");
		}
	}
	
	
}
