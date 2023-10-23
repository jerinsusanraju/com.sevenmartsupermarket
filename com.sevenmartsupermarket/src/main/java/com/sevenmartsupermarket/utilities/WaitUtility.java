package com.sevenmartsupermarket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	WebDriver driver;
	WebDriverWait wait;
	public static final long IMPLICIT_WAIT = 10;
	public static final long PAGE_LOAD_TIMEOUT = 20;

	public WaitUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void wait_ForElementToBeClickable(WebElement element, long time) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void wait_ForElementToBeVisisble(By locator, long time) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void wait_ForElementToBeVisisble(String xpath, long time) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	}
	
	///wait untilalert to be visible

}
