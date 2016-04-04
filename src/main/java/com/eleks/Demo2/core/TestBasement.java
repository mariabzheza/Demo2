package com.eleks.Demo2.core;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class TestBasement {

	protected WebDriver driver;
	protected String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	@Parameters({ "browsername" })
	public void setUp(@Optional ("chrome") String browsername) throws Exception {
		driver = WebDriverFactory.getDriver(browsername);
		baseUrl = "https://www.google.com.ua";
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		WebDriverFactory.killDriver();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
