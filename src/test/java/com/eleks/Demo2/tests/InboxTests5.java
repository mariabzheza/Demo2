package com.eleks.Demo2.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eleks.Demo2.core.TestBasement;
import com.eleks.Demo2.core.web.GmailPage;
import com.eleks.Demo2.core.web.InboxGmailPage;
import com.eleks.Demo2.core.web.MainGooglePage;

public class InboxTests5 extends TestBasement {

	@Test
	public void textContainingInMailSubjectAndBodyTest() {
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
		Assert.assertTrue(inboxPage.isPageAvailable());
		inboxPage.openMailWithSomeSubject("1 for my Demo");
		Assert.assertTrue(inboxPage.istextsContainsInBodyAndSubj("1 for my Demo", "type for you"));
	}
	
	@Test
	public void wrongTextContainingInMailSubjectAndBodyTest() {
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
		Assert.assertTrue(inboxPage.isPageAvailable());
		inboxPage.openMailWithSomeSubject("1 for my Demo");
		Assert.assertFalse(inboxPage.istextsContainsInBodyAndSubj(" tttttttttt fffff cv1 for my Demo", "type for you"));
	}

}
