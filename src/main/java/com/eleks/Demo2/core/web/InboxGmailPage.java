package com.eleks.Demo2.core.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InboxGmailPage extends PagesHelper {
	
	private By pageLocator = (By.xpath("//title"));
	private By accountLocator = (By.xpath("//a/span[@class='gb_1a gbii']"));
	// accountLocator //a/span[@class='gb_1a gbii']
	private By quitLocator = (By.xpath("//a[@id='gb_71']"));
	private By quitLocator1 = (By.xpath("//a[contains(@href, 'https://accounts.google.com/Logout')]"));
	//quitLocator //a[@id='gb_71']
	//private By mailLocator = By.xpath("//div/a[contains(@href, 'https://mail.google.com/mail')]");
	
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

	public InboxGmailPage openMailWithSomeSubject(String string) {
		//private By subjectLocator = (By.xpath("//span[contains(text(),'1 for my Demo')]"));
		//private By subjectLocator= (By.xpath(String.format("//span[contains(text(),'%s')]", string)));
		
		By locator = By.xpath(String.format("//span[contains(text(),'%s')]", string));
		if (!isElementPresent(locator)) {
			throw new IllegalStateException(" There is no such a letter containing \" " + string + "\" string in Subject! ");
		} else {
			click(locator);
			}
		return this;
	}
	
	public Boolean istextsContainsInBodyAndSubj(String subjStr, String bodyStr) {
		
		By subjectLocator = By.xpath(String.format("//h2[contains(text(),'%s')]", subjStr));
		//subjectLocator in letter page "//h2[contains(text(),'1 for my Demo')]"
		
		By bodyLocator = By.xpath(String.format("//tbody//span[contains(text(),'%s')]", bodyStr));
		//bodyLocator in letter page "//tbody//span[contains(text(),'type for you')]"
		
		if (!isElementPresent(subjectLocator) || !isElementPresent(bodyLocator) ) {
			
			return false;
		
		} else
			return true;
	}
	
	public GmailPage logOut() {
		click(accountLocator);
		//click(quitLocator);
		click(quitLocator1);
		return new GmailPage(driver);
	}
	
}
