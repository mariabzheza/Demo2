package com.eleks.Demo2.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod; 
import org.testng.annotations.BeforeMethod; 
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public abstract class TestBasement {

	protected WebDriver driver;
	protected String baseUrl;
	//private StringBuffer verificationErrors = new StringBuffer();

	@BeforeMethod
	@Parameters({ "browsername" })
	public void setUp(@Optional ("firefox") String browsername) throws Exception {
		driver = WebDriverFactory.getDriver(browsername);
		//baseUrl = "https://www.google.com.ua";
		baseUrl = "https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false#identifier";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		WebDriverFactory.killDriver();
	}

}
