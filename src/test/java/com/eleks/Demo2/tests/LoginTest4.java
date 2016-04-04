package com.eleks.Demo2.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	public void LoginTest() {
	
		driver.get(baseUrl);
		MainGooglePage googlePage = new MainGooglePage(driver);
		googlePage.goToLoginOnGmailPage();
		GmailPage gmailPage = new GmailPage(driver);
		gmailPage.enterEmailGoToLogIn("m123test1");
		
		wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
		driver.findElement(By.id("Passwd")).clear();
		driver.findElement(By.id("Passwd")).sendKeys("My_passw0rd159");
		driver.findElement(By.id("signIn")).click();
		//String j = driver.getTitle(); 
		//System.out.println("Your page title Is : "+j);
		Assert.assertTrue(driver.getTitle().endsWith("@gmail.com - Gmail"));
		
	}
}
