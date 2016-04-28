package com.eleks.Demo2.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eleks.Demo2.core.TestBasement;
import com.eleks.Demo2.core.web.GmailPage;
import com.eleks.Demo2.core.web.InboxGmailPage;
import com.eleks.Demo2.core.web.MainGooglePage;

public class LoginTests6 extends TestBasement {
	
	@Test
	public void loginWithCorrectPasswordTest111() {
		//File currentDir2 = new File(".");
        //System.out.println("1 --> " + currentDir2.getAbsolutePath());
		
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
	
	@Test(enabled = false)
	public void textContainingInMailSubjectAndBodyTest111() {
		driver.get(baseUrl);
		MainGooglePage googlePage = new MainGooglePage(driver);
		googlePage.goToLoginOnGmailPage();
		GmailPage gmailPage = new GmailPage(driver);
		gmailPage.typeEmail("m123test1");
		gmailPage.typePasswordAndSignIn("My_passw0rd159");
		InboxGmailPage inboxPage = new InboxGmailPage(driver);
		inboxPage.openMailWithSomeSubject("1 for my Demo");
		Assert.assertTrue(inboxPage.istextsContainsInBodyAndSubj("1 for my Demo", "type for you"));
		inboxPage.logOut();
	}
	
	@Test(enabled = false)
	public void wrongTextContainingInMailSubjectAndBodyTest111() {
		driver.get(baseUrl);
		MainGooglePage googlePage = new MainGooglePage(driver);
		googlePage.goToLoginOnGmailPage();
		GmailPage gmailPage = new GmailPage(driver);
		gmailPage.typeEmail("m123test1");
		gmailPage.typePasswordAndSignIn("My_passw0rd159");
		InboxGmailPage inboxPage = new InboxGmailPage(driver);
		inboxPage.openMailWithSomeSubject("1 for my Demo");
		Assert.assertFalse(inboxPage.istextsContainsInBodyAndSubj(" tttttttttt fffff cv1 for my Demo", "type for you"));
		inboxPage.logOut();
	}
	
}
