package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.ManageLocationPage;

public class ManageLocationTest extends Base{
	ManageLocationPage manageLocationPage;
	LoginPage loginPage;
		
	@Test(priority = 1)
	public void verifyListLocationsPageHeadingPresent() {
		manageLocationPage= new ManageLocationPage(driver);
		manageLocationPage.openManageLocationPage();
		boolean textDisplayed = manageLocationPage.listLocationsPageHeadingPresent();
		Assert.assertTrue(textDisplayed);
	}
	
	@Test(dependsOnMethods = "verifyListLocationsPageHeadingPresent")
	public void verifyListLocationsPageHeadingText() {
		manageLocationPage= new ManageLocationPage(driver);
		manageLocationPage.openManageLocationPage();
		boolean textMatches =manageLocationPage.ListLocationsPageHeadingText();
		Assert.assertTrue(textMatches);
	}
	
	
	public void verifyAddNewLocation() {
		manageLocationPage= new ManageLocationPage(driver);
		manageLocationPage.openManageLocationPage();
	}
	

}
