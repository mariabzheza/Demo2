package com.eleks.Demo2.core.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainGooglePage {
	
	private final WebDriver driver;
	
	public MainGooglePage(WebDriver driver) {
		this.driver = driver;
		if(!"Google".equals(driver.getTitle())) {
			throw new IllegalStateException("This is not the Main Google page!");
		}
	}
	
	public GmailPage goToLoginOnGmailPage() {
		driver.findElement(
				By.xpath("//div/a[contains(@href, 'https://mail.google.com/mail')]"))
				.click();
		return new GmailPage(driver);
	}

}
