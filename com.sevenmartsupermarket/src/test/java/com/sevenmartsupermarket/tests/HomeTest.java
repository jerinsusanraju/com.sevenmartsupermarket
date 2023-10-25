package com.sevenmartsupermarket.tests;

import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.HomePage;
import com.sevenmartsupermarket.pages.LoginPage;

public class HomeTest extends Base {
	HomePage homePage;
	LoginPage 	loginPage;
	
	@Test
	public void verifyCardTitle() {
		loginPage=new 	LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.login();
		homePage.getCardTitle();
	}
	

}
