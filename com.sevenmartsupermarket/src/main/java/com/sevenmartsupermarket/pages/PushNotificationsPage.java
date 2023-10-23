package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PushNotificationsPage {
	WebDriver driver;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-notifications']")
	private WebElement pushNotificationsLink;
	@FindBy(xpath = "//input[@id='title']")
	private WebElement enterTitleField;
	@FindBy(xpath = "//input[@id='description']")
	private WebElement enterDescriptionField;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	private WebElement sendButtonField;
	@FindBy(xpath = "//a[@class='btn btn-default btn-fix']")
	private WebElement resetButtonField;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alertSucessMessageField;

	public PushNotificationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickPushNotifications() {
		pushNotificationsLink.click();
	}

	public void enterTitle(String title) {
		enterTitleField.sendKeys(title);
	}

	public void enterDescription(String description) {
		enterDescriptionField.sendKeys(description);
	}

	public void clickSendButton() {
		sendButtonField.click();
	}

	public void sendNotification(String title, String description) {
		enterTitle(title);
		enterDescription(description);
		clickSendButton();

	}

	public boolean getSuccessMessage() {
		return alertSucessMessageField.isDisplayed();

	}
}
