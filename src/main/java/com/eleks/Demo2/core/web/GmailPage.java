package com.eleks.Demo2.core.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPage extends PagesHelper {
	
	private By pageLocator = (By.xpath("//title"));
	private By emailLocator = By.id("Email");
	private By nextBtnLocator = By.id("next");
	private By pswdLocator = By.id("Passwd");
	private By signInLocator = By.id("signIn");
	private By errorPswdLocator = By.xpath("//span[@id='errormsg_0_Email']");
	private By inboxLocator = (By.xpath("//title[contains(text(), '@gmail.com - Gmail')]"));
	
	String title = "Gmail";
	
	protected WebDriverWait wait;
	protected WebElement element;
	
	private WebDriver driver;
	
	public GmailPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
		/*if(!"Gmail".equals(driver.getTitle())) {
			throw new IllegalStateException("This is not the Gmail page!");
		}*/
	}
	
	public GmailPage typeEmail(String email){
		waitingForElementVisibility(emailLocator);
		type(emailLocator, email);
		click(nextBtnLocator);
		return this;
	}
	
	public InboxGmailPage typePasswordAndSignIn(String password) {
		waitingForElementVisibility(pswdLocator);
		type(pswdLocator, password);
		click(signInLocator);
		waitingForElementPresent(inboxLocator);
		return new InboxGmailPage(driver);
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
