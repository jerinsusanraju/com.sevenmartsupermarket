package com.sevenmartsupermarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	Select select;
	Actions actions;
	JavascriptExecutor js;

	public PageUtility(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;

	}

	public void select_byIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);

	}

	public void select_byVisibleText(WebElement element, String visibleText) {
		select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public void doubleClickOnElement(WebElement element) {
		actions.doubleClick(element).build().perform();
	}
	
	public void moveToElement(WebElement element) {
		actions.moveToElement(element).build().perform();
	}

	public void accept_Alert() {
		driver.switchTo().alert().accept();
	}

	public void dismiss_Alert() {
		driver.switchTo().alert().dismiss();
	}

	public String getTextOfAlert() {
		return driver.switchTo().activeElement().getText();
	}

	public void jsClick(WebElement element) {
		js.executeScript("arguments[0].click();", element);
			}
	
	public void jsScrollInToView(WebElement element) {
		js.executeScript("arguments[0].scrollInToView();", element);
	}
	
	public void scrollAndClick(WebElement element) {
		int index =0;
		while(! isClickHappened(element))
		{
			js.executeScript("window.scrollBy(0,"+index+")");
			index = index+3;
		}
	}
	
	public boolean isClickHappened(WebElement element) {
		try {
			element.click();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}
