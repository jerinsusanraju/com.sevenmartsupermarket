package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;

public class LoginTest extends Base {
	LoginPage loginPage;
	HomePage homePage;
	

	@Test
	public void verifyLogin() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		String userName=null;
		String password=null;
		loginPage.login(userName, password);
		String expectedProfileName = "Admin";
		String actualProfileName = homePage.getProfileName();
		Assert.assertEquals(actualProfileName, expectedProfileName);

	}

}
