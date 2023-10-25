package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.listeners.RetryAnalyzer;
import com.sevenmartsupermarket.pages.AdminUsersPage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.GeneralUtility;

public class AdminUsersTest extends Base {
	//LoginPage loginPage;
	AdminUsersPage adminUsersPage;


	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verifyCreateNewUser() {
		adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.openAdminUsersPage();
		String newUserName = GeneralUtility.getFirstName();
		String newUserPassword = null;
		String newUserType = null;
		adminUsersPage.createNewUser(newUserName, newUserPassword, newUserType);
		boolean userCreatedSuccessAlert = adminUsersPage.isUserCreatedAlertDisplayed();
		Assert.assertTrue(userCreatedSuccessAlert);
	}

	@Test(groups = "Smoke")
	public void verifyUserSearch() {
		adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.openAdminUsersPage();
		String srearchedUserNameExpected = adminUsersPage.userSearch();
		String srearchedUserNameActual = adminUsersPage.getUserSearchResult();
		System.out.println(srearchedUserNameExpected);
		System.out.println(srearchedUserNameActual);
		Assert.assertEquals(srearchedUserNameActual, srearchedUserNameExpected);
	}

	@Test
	public void verifyUserDeactivation() {
		adminUsersPage = new AdminUsersPage(driver);
		adminUsersPage.openAdminUsersPage();
		adminUsersPage.deactivateUser("Christena");
	}

}
