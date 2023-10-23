package com.sevenmartsupermarket.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	static int counter = 0;
	static int limit = 3;

	public boolean retry(ITestResult result) {
		if (counter < limit) {
			counter++;
			return true;
		} else {
			return false;
		}

	}
}
