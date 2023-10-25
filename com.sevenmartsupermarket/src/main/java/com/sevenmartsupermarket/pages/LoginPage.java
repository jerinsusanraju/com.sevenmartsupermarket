package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.constants.Constants;

public class LoginPage {
	WebDriver driver;
	Properties properties = new Properties();
	FileInputStream fi;
	@FindBy(xpath = "//input[@name='username']")
	private WebElement username_field;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password_field;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	private WebElement sign_in_button;
	@FindBy(xpath = "//input[@id='remember']")
	private WebElement remember_me_checkbox;
	@FindBy(xpath = "//label[contains(text(),'Remember Me')]")
	private WebElement remember_me_checkbox_label;

	public LoginPage(WebDriver driver) {
		try {
			fi = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fi);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("File not found");
		}
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enterUserName(String userName) {
		username_field.sendKeys(userName);
	}

	public void enterPassword(String password) {
		password_field.sendKeys(password);
	}

	public void clickOnSignInButton() {
		sign_in_button.click();
	}
	public void login() {
		String userName = properties.getProperty("username");
		String password = properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
	}

	public void login(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInButton();
		System.out.println("Changes1");
	}

}
