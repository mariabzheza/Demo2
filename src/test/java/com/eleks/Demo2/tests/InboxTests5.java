package com.eleks.Demo2.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eleks.Demo2.core.TestBasement;
import com.eleks.Demo2.core.web.GmailPage;
import com.eleks.Demo2.core.web.InboxGmailPage;
import com.eleks.Demo2.core.web.MainGooglePage;

public class InboxTests5 extends TestBasement {

	@Test(priority = 2)
	public void textContainingInMailSubjectAndBodyTest() {
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
	
	@Test(priority = 1)
	public void wrongTextContainingInMailSubjectAndBodyTest() {
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
