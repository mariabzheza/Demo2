package com.eleks.Demo2.core.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPage extends PagesHelper {
	
	private By pageLocator = (By.xpath("//title"));
	//private By emailLocator = By.id("Email");
	private By emailLocatorByXPath = By.xpath("//form[@action]//input[@type='email']");
	private By nextBtnLocator = By.id("next");
	private By pswdLocator = By.id("Passwd");
	private By signInLocator = By.id("signIn");
	private By errorPswdLocator = By.xpath("//span[@id='errormsg_0_Email']");
	private By inboxLocator = (By.xpath("//title[contains(text(), '@gmail.com - Gmail')]"));
	
	protected WebDriverWait wait;
	protected WebElement element;
	
	private String title = "Gmail";
	
	public GmailPage(WebDriver driver) {
		super(driver);
	}
	
	public WebDriver getDriver() {
		return super.getDriver();
	}
	
	public GmailPage typeEmail(String email){
		//waitingForElementVisibility(emailLocator);
		waitingForElementVisibility(emailLocatorByXPath);
		type(emailLocatorByXPath, email);
		click(nextBtnLocator);
		return this;
	}
	
	public InboxGmailPage typePasswordAndSignIn(String password) {
		waitingForElementVisibility(pswdLocator);
		type(pswdLocator, password);
		click(signInLocator);
		waitingForElementPresent(inboxLocator);
		return new InboxGmailPage(this.getDriver());
	}
	
	public GmailPage typeWrongPassword(String password) {
		waitingForElementVisibility(pswdLocator);
		type(pswdLocator, password);
		if(!isElementPresent(errorPswdLocator)){
			throw new IllegalStateException("Warning about incorrect password is absent!!!");
		}
		
		return this;
	}

	@Override
	public Boolean isPageAvailable() {
		waitingForElementPresent(pageLocator);
		if (correctPageByTitle(title)) {
			return true;
		} return false;
	}
	
}
