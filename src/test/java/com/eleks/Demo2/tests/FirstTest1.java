package com.eleks.Demo2.tests;

import org.testng.annotations.Test;

import com.eleks.Demo2.core.TestBasement;

public class FirstTest1 extends TestBasement {
	
	@Test
	public void testMethod() {
		driver.get("https://www.google.com.ua/");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {}
	}

}
