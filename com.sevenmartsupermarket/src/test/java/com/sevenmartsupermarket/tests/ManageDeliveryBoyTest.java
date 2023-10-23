package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageDeliveryBoyPage;

public class ManageDeliveryBoyTest extends Base {
	LoginPage loginPage;
	ManageDeliveryBoyPage manageDeliveryBoyPage;

	@Test(groups = { "Smoke", "Regression" })
	public void verifyAddNewDeliveryBoy() {
		manageDeliveryBoyPage = new ManageDeliveryBoyPage(driver);
		manageDeliveryBoyPage.openDeliveryBoyPage();
		manageDeliveryBoyPage.clickOnNewButton();
		manageDeliveryBoyPage.enterDeliveryBoyDetails();
		manageDeliveryBoyPage.clickOnSave();
		boolean sucessMessageDisplayed = manageDeliveryBoyPage.successMessageIsDisplayed();
		Assert.assertTrue(sucessMessageDisplayed);
	}

}
