package com.eleks.Demo2.core.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPage {
	
	private String emailId = "Email";
	private String nextButton = "next";
	
	protected WebDriverWait wait;
	protected WebElement element;
	private final WebDriver driver;
	
	public GmailPage(WebDriver driver) {
		this.driver = driver;
		
		if(!"Gmail".equals(driver.getTitle())) {
			throw new IllegalStateException("This is not the Gmail page!");
		}
	}
	
//	public LoginPage enterEmailGoToLogIn(String email){
	public WebDriver enterEmailGoToLogIn(String email){
		typeEmailById(emailId, email);
		clickButtonById(nextButton);
		//return new LoginPage(driver);
		return this.driver;
	}

	private GmailPage clickButtonById(String string) {
		driver.findElement(By.id(string)).click();
		return this;
		
	}

	private GmailPage typeEmailById(String string, String email) {
		visibilityOfElementLocatedById(string);
		driver.findElement(By.id(string)).clear();
		driver.findElement(By.id(string)).sendKeys(email);
		return this;
		
	}

	protected void visibilityOfElementLocatedById(String string) {
		wait = new WebDriverWait(driver, 10);
		element = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.id(string)));
	}

}
