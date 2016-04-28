package com.eleks.Demo2.tests;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eleks.Demo2.core.TestBasement;

public class LoginTests3 extends TestBasement {
	protected WebDriverWait wait;
	protected WebElement element;

	@Test
	public void LoginTest() {
		
		wait = new WebDriverWait(driver, 10);
		driver.get(baseUrl);
		assertEquals(driver.getTitle(), "Google");
		driver.findElement(
				By.xpath("//div/a[contains(@href, 'https://mail.google.com/mail')]"))
				.click();
		element = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("m123test1");
		driver.findElement(By.id("next")).click();
		
		
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));
		driver.findElement(By.id("Passwd")).clear();
		driver.findElement(By.id("Passwd")).sendKeys("My_passw0rd159");
		driver.findElement(By.id("signIn")).click();
		//String j = driver.getTitle(); 
		//System.out.println("Your page title Is : "+j);
		Assert.assertTrue(driver.getTitle().endsWith("@gmail.com - Gmail"));
	}

}
