package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.pages.PushNotificationsPage;
import com.sevenmartsupermarket.utilities.Excel;

public class PushNotificationsTest extends Base {

	LoginPage loginPage;
	PushNotificationsPage pushNotificationsPage;
	Excel excel = new Excel();

	@Test(groups = "Smoke")
	public void verifyClickPushNotificationsLink() {
		loginPage = new LoginPage(driver);
		pushNotificationsPage = new PushNotificationsPage(driver);
		String userName = null;
		String password = null;
		loginPage.login(userName, password);
		excel.setExcelFile("NotificationsData", "PushNotifications");
		pushNotificationsPage.clickPushNotifications();
		String title = excel.getCellData(0, 0);
		String description = excel.getCellData(0, 1);
		pushNotificationsPage.sendNotification(title, description);
		boolean alertSucessMessageActual = pushNotificationsPage.getSuccessMessage();
		Assert.assertTrue(alertSucessMessageActual);

	}

}
