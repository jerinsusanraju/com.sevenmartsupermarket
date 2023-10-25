package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.PageUtility;
import com.sevenmartsupermarket.constants.Constants;

public class ManageDeliveryBoyPage {
	WebDriver driver;
	FileInputStream fi;
	PageUtility pageUtility;
	Properties properties = new Properties();

	@FindBy(xpath = "//p[text()='Manage Delivery Boy']")
	private WebElement manageDeliveryBoyLink;
	@FindBy(xpath = "//a[text()=' New']")
	private WebElement newButton;
	@FindBy(xpath = "//input[@id='name']")
	private WebElement nameField;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailField;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phoneNbrField;
	@FindBy(xpath = "//textarea[@id='address']")
	private WebElement addressField;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@name='create']")
	private WebElement saveField;
	@FindBy(xpath = "//i[@class='icon fas fa-check']")
	private WebElement successAlert;

	public ManageDeliveryBoyPage(WebDriver driver) {
		try {
			fi = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fi);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File not found");
		}
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnDeliveryBoyLink() {
		manageDeliveryBoyLink.click();
	}

	public void clickOnNewButton() {
		newButton.click();
	}

	public void clickOnSave() {
		pageUtility = new PageUtility(driver);
		pageUtility.jsClick(saveField);
	}
	
	public void openDeliveryBoyPage() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();
		clickOnDeliveryBoyLink();
	}

	public void enterDeliveryBoyDetails() {
		String deliveryBoyName = GeneralUtility.getFirstName();
		nameField.sendKeys(deliveryBoyName);
		String deliveryBoyEmail = deliveryBoyName + "@gmail.com";
		emailField.sendKeys(deliveryBoyEmail);
		String deliveryBoyPhone = properties.getProperty("phone");
		phoneNbrField.sendKeys(deliveryBoyPhone);
		String deliveryBoyAddress = GeneralUtility.getStreetAddress();
		addressField.sendKeys(deliveryBoyAddress);
		userNameField.sendKeys(deliveryBoyName);
		String deliverBoyPassword = properties.getProperty("newuserpassword");
		passwordField.sendKeys(deliverBoyPassword);

	}

	public boolean successMessageIsDisplayed() {
		return successAlert.isDisplayed();
	}

}
