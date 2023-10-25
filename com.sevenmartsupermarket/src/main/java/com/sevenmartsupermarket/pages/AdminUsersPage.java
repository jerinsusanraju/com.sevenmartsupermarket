package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.PageUtility;


public class AdminUsersPage {
	WebDriver driver;
	PageUtility pageUtility;
	GeneralUtility generalUtility;
	FileInputStream fi;
	Properties properties = new Properties();

	@FindBy(xpath = "//p[text()='Admin Users']")
	private WebElement adminUsersLink;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newField;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernameField;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userTypeField;
	@FindBy(xpath = "//button[@name='Create']")
	private WebElement saveField;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//following::i[@class='icon fas fa-check']")
	private WebElement userCreatedMessageField;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchIconField;
	@FindBy(xpath = "//input[@id='un']")
	WebElement userNameInSearchField;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButtonField;
	@FindBy(xpath = "(//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td)[1]")
	WebElement searchedUserNameField;
	@FindBy(xpath = "//table[contains(@class,'table')]//tbody//tr//td[1]")
	private List<WebElement> names;

	public AdminUsersPage(WebDriver driver) {
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

	public void openAdminUsersPage() {
		LoginPage loginPage = new LoginPage(driver);
		String userName = null;
		String password = null;
		loginPage.login(userName, password);
		adminUsersLink.click();
	}

	public void clickOnNewButton() {
		newField.click();
	}

	public void enterUserName(String newUserName) {
		usernameField.sendKeys(newUserName);
	}

	public void enterPassword(String newUserPassword) {
		passwordField.sendKeys(newUserPassword);
	}

	public void chooseUserType(String newUserType) {
		pageUtility = new PageUtility(driver);
		pageUtility.select_byVisibleText(userTypeField, newUserType);
	}

	public void clickOnSave() {
		saveField.click();
	}
/***
 * This method is for new user creation	
 * @param newUserName
 * @param newUserPassword
 * @param newUserType
 */
	public void createNewUser(String newUserName, String newUserPassword, String newUserType) {
		
		clickOnNewButton();
		enterUserName(newUserName);
		enterPassword(newUserPassword);
		chooseUserType(newUserType);
		clickOnSave();
	}

	public boolean isUserCreatedAlertDisplayed() {
		return userCreatedMessageField.isDisplayed();
	}

	public void clickOnSearchIcon() {
		searchIconField.click();
	}

	public String userNameToBeSearched() {
		String userNameToSearch = properties.getProperty("newusername");
		userNameInSearchField.sendKeys(userNameToSearch);
		return userNameToSearch;
	}

	public void clickOnSearch() {
		searchButtonField.click();
	}

	public String getUserSearchResult() {
		String srearchedUserName = searchedUserNameField.getText();
		return srearchedUserName;
	}

	public String userSearch() {
		clickOnSearchIcon();
		String searchedName = userNameToBeSearched();
		clickOnSearch();
		return searchedName;
	}

	public void deactivateUser(String personName) {
		generalUtility = new GeneralUtility(driver);
		pageUtility = new PageUtility(driver);
		List<String> userNames = new ArrayList<String>();
		userNames = generalUtility.get_text_of_elements(names);
		System.out.println(userNames);
		int index = 0;
		for (index = 0; index < userNames.size(); index++) {
			if (userNames.get(index).equals(personName)) {
				index++;
				break;
			}
		}
		WebElement deactivateButton = driver
				.findElement(By.xpath("//table[contains(@class,'table')]//tbody//tr[" + index + "]//td[5]/a[1]"));
		pageUtility.scrollAndClick(deactivateButton);
	}

}
