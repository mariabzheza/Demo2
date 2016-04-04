package com.eleks.Demo2.core.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPage extends PagesHelper {
	
	private By emailLocator = By.id("Email");
	private By nextBtnLocator = By.id("next");
	private By pswLocator = By.id("Passwd");
	private By signInLocator = By.id("signIn");
	
	protected WebDriverWait wait;
	protected WebElement element;
	
	private WebDriver driver;
	
	public GmailPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
		if(!"Gmail".equals(driver.getTitle())) {
			throw new IllegalStateException("This is not the Gmail page!");
		}
	}
	
	public GmailPage typeEmail(String email){
		waitingForElementVisibility(emailLocator);
		type(emailLocator, email);
		click(nextBtnLocator);
		return this;
	}
	
	public InboxGmailPage typePasswordAndSignIn(String password) {
		waitingForElementVisibility(pswLocator);
		type(pswLocator, password);
		click(signInLocator);
		return new InboxGmailPage(driver);
	}

}
