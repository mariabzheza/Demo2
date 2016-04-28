package com.eleks.Demo2.core.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainGooglePage extends PagesHelper {
	
	private By mailLocator = By.xpath("//div/a[contains(@href, 'https://mail.google.com/mail')]");
	private By pageLocator = (By.xpath("//title"));
	private String title = "Google";
	
	public MainGooglePage(WebDriver driver) {
		super(driver);
		//this.driver = driver;
		/*if(!"Gmail".equals(driver.getTitle())) {
		throw new IllegalStateException("This is not the Gmail page!");
	}*/
	}
	
	public GmailPage goToLoginOnGmailPage() {
		waitingForElementPresent(mailLocator);
		click(mailLocator);
		return new GmailPage(this.getDriver());
	}

	@Override
	public Boolean isPageAvailable() {
		waitingForElementPresent(pageLocator);
		if (correctPageByTitle(title)) {
			return true;
		} return false;
	}

}
