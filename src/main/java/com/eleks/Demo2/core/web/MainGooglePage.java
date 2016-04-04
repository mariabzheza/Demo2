package com.eleks.Demo2.core.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainGooglePage extends PagesHelper {
	
	private By mailLocator = By.xpath("//div/a[contains(@href, 'https://mail.google.com/mail')]");
	
	private WebDriver driver;
	
	public MainGooglePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
		if(!"Google".equals(driver.getTitle())) {
			throw new IllegalStateException("This is not the Main Google page!");
		}
	}
	
	public GmailPage goToLoginOnGmailPage() {
		click(mailLocator);
		return new GmailPage(driver);
	}

}
