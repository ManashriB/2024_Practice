package com.AmazonDemo;

import org.testng.annotations.DataProvider;

public class DiffDataProviderClass {

	@DataProvider
	public Object[][] amazonLoginTestData() {
		return new Object[][] {

				new Object[] { "8483860062", "Manu@123" }, 
				new Object[] { "8483860062", "Manu@124" }, 
				
		};
	}

}
