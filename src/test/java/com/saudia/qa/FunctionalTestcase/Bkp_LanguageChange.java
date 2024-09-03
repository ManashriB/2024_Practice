package com.saudia.qa.FunctionalTestcase;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.pages.HomePage;
import com.saudia.qa.pages.PassengerDetailsPage;
import com.saudia.qa.pages.PaymentPage;
import com.saudia.qa.pages.SignInPage;
import com.saudia.qa.util.ExcelUtill;
import com.saudia.qa.util.GetTestData;
import com.saudia.qa.util.ReportLog;
import com.saudia.qa.util.Utilities;





public class Bkp_LanguageChange extends TestBase {
	protected Utilities utils;
//	public ReportLog reports;
	protected ExcelUtill excel;
	ArrayList<String> values = new ArrayList<>();
	protected String pnr = null; 

	public Bkp_LanguageChange() {
		super();
	}


	
	@BeforeMethod
	public void setup(Method m) throws IOException {
		// initliazing the classes
		String filePath ="";
		signInPage = new SignInPage(reports);
		excel = new ExcelUtill(filePath, 1);
		reports.startTest(m.getName(), "BanumathiS", "Booking RoundTrip");
	}


	@Test(priority= 1 , description = "Changing the language")
	public void langChange() throws Throwable {
		
		
		try {
			
			HomePage homePage = new HomePage(reports);
			homePage.acceptPrivacyCookies();
			homePage.changeCountryIndiaToSaudiArabia(GetTestData.searchCountryText);
	
			System.out.println("ddd");
			 
		} catch (Exception e) {
			reports.logFail("Booking", "Error while doing Booking");
			reports.logFail(e.getMessage(), "Unable to do Booking...");
		}
	}
		
	
		@AfterMethod
	public void tearDown() {
			reports.endTest();

	}

		

	

}
