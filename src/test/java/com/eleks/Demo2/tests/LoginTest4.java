package com.eleks.Demo2.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eleks.Demo2.core.TestBasement;
import com.eleks.Demo2.core.web.GmailPage;
import com.eleks.Demo2.core.web.MainGooglePage;

public class LoginTest4 extends TestBasement {
	
	protected WebDriverWait wait;
	protected WebElement element;
	
	@Test
	public void loginWithCorrectPasswordTest() {
	
		driver.get(baseUrl);
		MainGooglePage googlePage = new MainGooglePage(driver);
		googlePage.goToLoginOnGmailPage();
		GmailPage gmailPage = new GmailPage(driver);
		gmailPage.typeEmail("m123test1");
		gmailPage.typePasswordAndSignIn("My_passw0rd159");
		//String j = driver.getTitle(); 
		//System.out.println("Your page title Is : "+j);
		Assert.assertTrue(driver.getTitle().endsWith("@gmail.com - Gmail"));
	}
	
	@Test
	public void loginWithIncorrectPasswordTest() {
	
		driver.get(baseUrl);
		MainGooglePage googlePage = new MainGooglePage(driver);
		googlePage.goToLoginOnGmailPage();
		GmailPage gmailPage = new GmailPage(driver);
		gmailPage.typeEmail("m123test1");
		gmailPage.typeWrongPassword("My1234");
		Assert.assertTrue(driver.getTitle().equals("Gmail"));
	}
	
}
