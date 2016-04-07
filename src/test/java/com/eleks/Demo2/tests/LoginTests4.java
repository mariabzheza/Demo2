package com.eleks.Demo2.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eleks.Demo2.core.TestBasement;
import com.eleks.Demo2.core.web.GmailPage;
import com.eleks.Demo2.core.web.InboxGmailPage;
import com.eleks.Demo2.core.web.MainGooglePage;

public class LoginTests4 extends TestBasement {
	
	@Test
	public void loginWithCorrectPasswordTest() {
	
		driver.get(baseUrl);
		MainGooglePage googlePage = new MainGooglePage(driver);
		Assert.assertTrue(googlePage.isPageAvailable());
		googlePage.goToLoginOnGmailPage();
		GmailPage gmailPage = new GmailPage(driver);
		Assert.assertTrue(gmailPage.isPageAvailable());
		gmailPage.typeEmail("m123test1");
		gmailPage.typePasswordAndSignIn("My_passw0rd159");
		Assert.assertTrue(driver.getTitle().endsWith("@gmail.com - Gmail"));
		InboxGmailPage inboxPage = new InboxGmailPage(driver);
		inboxPage.logOut();
	}
	
	@Test
	public void loginWithIncorrectPasswordTest() {
	
		driver.get(baseUrl);
		MainGooglePage googlePage = new MainGooglePage(driver);
		Assert.assertTrue(googlePage.isPageAvailable());
		googlePage.goToLoginOnGmailPage();
		GmailPage gmailPage = new GmailPage(driver);
		Assert.assertTrue(gmailPage.isPageAvailable());
		gmailPage.typeEmail("m123test1");
		gmailPage.typeWrongPassword("My1234");
		Assert.assertTrue(driver.getTitle().equals("Gmail"));
	}
	
}
