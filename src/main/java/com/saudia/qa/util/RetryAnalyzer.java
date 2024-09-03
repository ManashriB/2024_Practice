package com.saudia.qa.util;



import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int count =0,attempt=3;
	
	
	
/**
	
	* this method decides how many time should test should run TestNg
	* call this method every time a test is failed
	*  this méthod will return true every time a test is failed
	* needs to be retrieved if u get false conditions
	**/
	
	@Override
	public boolean retry(ITestResult result) {
		if (count<attempt) {
			return true;
		} else {
			return false;
		}
		
	}

	
	
}
