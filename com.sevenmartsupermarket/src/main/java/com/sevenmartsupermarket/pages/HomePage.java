package com.sevenmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.GeneralUtility;

public class HomePage {
	WebDriver driver;
	GeneralUtility generalUtility;
	@FindBy(xpath = "//div[@class='info']")
	private WebElement profile_name;
	@FindBy(xpath = "//div[@class='inner']//p")
	private List<WebElement> card;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String getProfileName() {
		return profile_name.getText();
	}

	public List<String> getCardTitle() {
		generalUtility = new GeneralUtility(driver);
		List<String> data = new ArrayList<>();
		data = generalUtility.get_text_of_elements(card);
		System.out.println(data);
		return data;
	}
}
