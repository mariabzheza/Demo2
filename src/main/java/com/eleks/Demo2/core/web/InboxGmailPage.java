package com.eleks.Demo2.core.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InboxGmailPage extends PagesHelper {
	
	private By pageLocator = (By.xpath("//title"));
	String title = "@gmail.com - Gmail";
	
	private WebDriver driver;
	
	public InboxGmailPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Override
	public Boolean isPageAvailable() {
		waitingForElementPresent(pageLocator);
		if( !driver.getTitle().contains(title)) {
			throw new IllegalStateException("This is not the " + title + " page!");
		} return true;
	}
	
}
