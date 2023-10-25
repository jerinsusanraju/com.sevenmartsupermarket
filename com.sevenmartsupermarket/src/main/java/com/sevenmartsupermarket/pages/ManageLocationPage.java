package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.constants.Constants;

public class ManageLocationPage {
	WebDriver driver;
	GeneralUtility generalUtility;
	FileInputStream fi;
	Properties properties = new Properties();

	@FindBy(xpath = "//p[text()='Manage Location']")
	private WebElement manageLocation;
	@FindBy(xpath = "//a[text()=' New']")
	private WebElement newButton;
	@FindBy(xpath = "//div[@class='col-sm-6']//following::h1")
	private WebElement listLocations;

	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			fi = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fi);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File not found");
		}
	}

	public void openManageLocationPage() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();
		manageLocation.click();
	}

	public boolean listLocationsPageHeadingPresent() {
		generalUtility = new GeneralUtility(driver);
		return generalUtility.is_text_displayed(listLocations);
	}

	public boolean ListLocationsPageHeadingText() {
		generalUtility = new GeneralUtility(driver);
		String expected = properties.getProperty("listlLocations");
		return generalUtility.is_text_present(listLocations, expected);
	}
}
