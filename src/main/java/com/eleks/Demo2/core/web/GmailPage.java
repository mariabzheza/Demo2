package com.eleks.Demo2.core.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPage extends PagesHelper {
	
	private By emailLocator = By.id("Email");
	private By nextBtnLocator = By.id("next");
	
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
	
//	public LoginPage enterEmailGoToLogIn(String email){
	public WebDriver enterEmailGoToLogIn(String email){
		//typeEmailById(emailLocator, email);
		waitingForElementVisibility(emailLocator);
		type(emailLocator, email);
		
		click(nextBtnLocator);
		//return new LoginPage(driver);
		return this.driver;
	}

	private GmailPage typeEmailById(By Locator, String string) {
		waitingForElementVisibility(emailLocator);
		type(emailLocator, string);
		return this;
		
	}

}
