package com.eleks.Demo2.core.web;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PagesHelper {

	private WebDriver driver;
	protected WebDriverWait wait;
	protected WebElement element;

	private boolean acceptNextAlert = true;

	//protected By findByMethod;

	public PagesHelper(WebDriver driver) {
		this.driver = driver;
	}

	abstract Boolean isPageAvailable();

	protected void type(By locator, String text) {
		if (text != null) {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(text);
		}
	}

	protected WebDriver getDriver() {
		return driver;
	}

	protected void click(By locator) {
		driver.findElement(locator).click();
	}

	// !!!
	protected void selectByText(By locator, String text) {
		if (text != null) {
			new Select(driver.findElement(locator)).selectByVisibleText(text);
		}
	}

	protected void waitingForElementVisibility(By locator) {
		wait = new WebDriverWait(driver, 50);
		element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
	}

	protected void waitingForElementPresent(By locator) {
		wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions
				.presenceOfElementLocated(locator));
	}

	/*
	 * protected void waitingForPageLoad() { IWait<IWebDriver> wait = new
	 * OpenQA.Selenium.Support.UI.WebDriverWait(driver,
	 * TimeSpan.FromSeconds(30.00));
	 * 
	 * wait.Until(driver1 =>
	 * ((IJavaScriptExecutor)driver).ExecuteScript("return document.readyState"
	 * ).Equals("complete")); }
	 */

	protected void visibilityOfElementLocatedById(String string) {
		wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.id(string)));
	}

	protected Boolean correctPageByTitle(String title) {
		if (!title.equals(driver.getTitle())) {
			String j = driver.getTitle();
			System.out.println("Your page title Is : " + j);
			throw new IllegalStateException("This is not the " + title
					+ " page!");
		} else
			return true;
	}

	// !!!!!
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	/*
	 * public boolean isAvailable(){ try{ return getWebElement() != null; }
	 * catch (NoSuchElementException e) { return false; } }
	 * 
	 * protected WebElement getWebElement() { return
	 * driver.findElement(findByMethod); }
	 * 
	 * public void click() { getWebElement().click(); }
	 * 
	 * public String getText() { return getWebElement().getText(); }
	 */
}
