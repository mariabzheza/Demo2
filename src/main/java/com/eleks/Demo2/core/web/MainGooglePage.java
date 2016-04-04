package com.eleks.Demo2.core.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainGooglePage extends PagesHelper {
	
	private WebDriver driver;
	private By mailLocator = By.xpath("//div/a[contains(@href, 'https://mail.google.com/mail')]");
	private By pageLocator = (By.xpath("//title"));
	String title = "Google";
	
	
	public MainGooglePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	
	public GmailPage goToLoginOnGmailPage() {
		waitingForElementPresent(mailLocator);
		click(mailLocator);
		return new GmailPage(driver);
	}

	@Override
	public Boolean isPageAvailable() {
		waitingForElementPresent(pageLocator);
		if (correctPageByTitle(title)) {
			return true;
		} return false;
	}

}
