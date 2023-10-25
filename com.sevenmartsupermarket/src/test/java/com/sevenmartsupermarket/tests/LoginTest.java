package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;

public class LoginTest extends Base {
	LoginPage loginPage;
	HomePage homePage;

	@Test
	public void verifyLogin() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.login();
		String expectedProfileName = "Admin";
		String actualProfileName = homePage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);

	}

	@Test(dataProvider = "AdminUsers", dataProviderClass = Constants.class)
	public void verifyAdminLogin(String userName, String password) {
		loginPage = new LoginPage(driver);
		loginPage.login(userName, password);
	}

}
