package com.sevenmartsupermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.sevenmartsupermarket.constants.Constants;

public class Screenshot {

	TakesScreenshot takeScreenshot;

	public void takeScreenShot(WebDriver driver, String imageName) {

		try {
			takeScreenshot = (TakesScreenshot) driver;
			File screenshot = takeScreenshot.getScreenshotAs(OutputType.FILE); // capture screenshot
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			String path = Constants.SCREENSHOT_FILE_PATH + imageName + "_" + timeStamp + ".png";
			File destination = new File(path);
			FileHandler.copy(screenshot, destination); // to move screenshot from source to destination

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("File not found");
		}

	}

}
