package com.sevenmartsupermarket.utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {
	WebDriver driver;
	static Faker faker = new Faker();

	public GeneralUtility(WebDriver driver) {
		this.driver = driver;
	}

	public String getTextOfElement(WebElement element) {
		return element.getText();

	}

	public List<String> get_text_of_elements(List<WebElement> elements) {
		List<String> data = new ArrayList<String>();
		for (WebElement e : elements) {
			String text = e.getText();
			data.add(text);
		}
		return data;
	}

	public String get_attribute(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public String get_cSSValue(WebElement element, String cssProperty) {
		return element.getCssValue(cssProperty);
	}

	public boolean is_text_present(WebElement element, String expected_text) {
		String data = element.getText();
		return data.equals(expected_text);
	}
	
	public boolean is_text_displayed(WebElement element) {
		boolean data = element.isDisplayed();
		return data;
	}
	
		public static String getFullName() {
		String name = faker.name().fullName();
		return name;
	}

	public static String getFirstName() {
		String firstName = faker.name().firstName();
		return firstName;
	}

	public static String getLastName() {
		String lastName = faker.name().lastName();
		return lastName;
	}

	public static String getStreetAddress() {
		String streetAddress = faker.address().streetAddress();
		return streetAddress;
	}

}
