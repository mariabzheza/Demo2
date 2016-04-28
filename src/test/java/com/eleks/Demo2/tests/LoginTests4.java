package com.eleks.Demo2.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eleks.Demo2.core.TestBasement;
import com.eleks.Demo2.core.web.GmailPage;
import com.eleks.Demo2.core.web.InboxGmailPage;

public class LoginTests4 extends TestBasement {
	
	@Test(dependsOnMethods = { "loginWithIncorrectPasswordTest" })	
	public void loginWithCorrectPasswordTest() {
		
		driver.get(baseUrl);
		GmailPage gmailPage = new GmailPage(driver);
		Assert.assertTrue(gmailPage.isPageAvailable());
		gmailPage.typeEmail("m123test1").typePasswordAndSignIn("My_passw0rd159");
		Assert.assertTrue(gmailPage.getDriver().getTitle().endsWith("@gmail.com - Gmail"));
		InboxGmailPage inboxPage = new InboxGmailPage(driver);
		inboxPage.logOut();
	}
	
	@Test
	public void loginWithIncorrectPasswordTest() {
	
		driver.get(baseUrl);
		GmailPage gmailPage = new GmailPage(driver);
		Assert.assertTrue(gmailPage.isPageAvailable());
		gmailPage.typeEmail("m123test1").typeWrongPassword("My1234");
		//Assert.assertTrue(driver.getTitle().equals("Gmail"));
		Assert.assertTrue(gmailPage.getDriver().getTitle().equals("Gmail"));
	}
	
}
