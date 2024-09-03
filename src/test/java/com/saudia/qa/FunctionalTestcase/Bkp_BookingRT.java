package com.saudia.qa.FunctionalTestcase;


import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.pages.HomePage;
import com.saudia.qa.pages.PassengerDetailsPage;
import com.saudia.qa.pages.PaymentPage;
import com.saudia.qa.pages.SignInPage;
import com.saudia.qa.util.ExcelUtill;
import com.saudia.qa.util.GetTestData;
import com.saudia.qa.util.Utilities;





public class Bkp_BookingRT extends TestBase {
	protected Utilities utils;
//	public ReportLog reports;
	protected ExcelUtill excel;
	ArrayList<String> values = new ArrayList<>();
	protected String pnr = null; 

	public Bkp_BookingRT() {
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


	@Test(priority= 1 , description = "Validate the PNR creation")
	public void OneWayDOM() throws Throwable {
		
		
		try {
			String origin1 ="JED";
			String destination1 ="RUH";
			
			HomePage homePage = new HomePage(reports);
			PassengerDetailsPage passengerdetailspage = new PassengerDetailsPage(reports);
			PaymentPage paymentpages = new PaymentPage(reports);
			homePage.acceptPrivacyCookies();
			homePage.changeCountryIndiaToSaudiArabia(GetTestData.searchCountryText);
		//	homePage.webtable();
			
			homePage.oneWayTripMethod(origin1, destination1);
			homePage.datepickerCalOW("February 2024" , "17");
		//	homePage.addPassenger();
		//	homePage.selectjourneydatesOW();
			homePage.dontChangeBTNMethod();
			homePage.selectFareCardRT();
			homePage.clickContToPassenger();
			passengerdetailspage.addPassengerDetails(GetTestData.title, GetTestData.firstName, GetTestData.lastName,
					GetTestData.birthdayDate, GetTestData.nationality, GetTestData.passportNumber,
					GetTestData.passportExpiryDate, GetTestData.passportIssuingCountry);
			passengerdetailspage.addContactDetails(GetTestData.countryCode, GetTestData.phoneNumber, GetTestData.email);
		//	paymentpages.enterCardDetails();
			
		
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
