package com.sevenmartsupermarket.constants;

import org.testng.annotations.DataProvider;

import com.sevenmartsupermarket.utilities.Excel;

public class Constants {
	Excel excel = new Excel();
	public static final String CONFIG_FILE_PATH = System.getProperty("user.dir")
			+ "//src//main//resources//config.properties";
	public static final String EXCEL_FILE_PATH = System.getProperty("user.dir")
			+ "//src//main//resources//ExcelFiles//";
	public static final String SCREENSHOT_FILE_PATH = System.getProperty("user.dir") + "//Screenshots//";
	public static final String EXTEND_REPORT_PATH = System.getProperty("user.dir") + "//ExtendReports";

	/** Login Test case data ***/
	@DataProvider(name = "AdminUsers")
	public Object[][] CredentialDataAdminUser() {
		excel.setExcelFile("LoginData", "Valid");
		return excel.getMultiDimensionalData(3, 2);

	}

}
