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
import com.saudia.qa.pages.SeatsAndExtras;
import com.saudia.qa.pages.SignInPage;
import com.saudia.qa.util.ExcelUtill;
import com.saudia.qa.util.GetTestData;
import com.saudia.qa.util.ReportLog;
import com.saudia.qa.util.Utilities;





public class Bkp_RegressionScenarios extends TestBase {
	protected Utilities utils;
//	public ReportLog reports;
	protected ExcelUtill excel;
	ArrayList<String> values = new ArrayList<>();
	protected String pnr = null; 

	public Bkp_RegressionScenarios() {
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


	@Test(enabled=false , description = "One way DOM route booking")
	public void OneWayDOMRoute() throws Throwable {
		
		
		try {
			String origin1 ="JED";
			String destination1 ="RUH";
			
			HomePage homePage = new HomePage(reports);
			PassengerDetailsPage passengerdetailspage = new PassengerDetailsPage(reports);
			SeatsAndExtras ancillariesPage = new SeatsAndExtras(reports);
			PaymentPage paymentpages = new PaymentPage(reports);
			homePage.acceptPrivacyCookies();
			homePage.changeCountryIndiaToSaudiArabia(GetTestData.searchCountryText);
			homePage.oneWayTripMethod(origin1, destination1);
			homePage.datepickerCalOW("February 2024" , "17");
			homePage.dontChangeBTNMethod();
			homePage.selectGuestBasicFareCardOW();
			homePage.clickContToPassenger();
			passengerdetailspage.addPassengerDetails(GetTestData.title, GetTestData.firstName, GetTestData.lastName,
					GetTestData.birthdayDate, GetTestData.nationality, GetTestData.passportNumber,
					GetTestData.passportExpiryDate, GetTestData.passportIssuingCountry);
			passengerdetailspage.addContactDetails(GetTestData.countryCode, GetTestData.phoneNumber, GetTestData.email);
			//ancillariesPage.addaddFastTrackOW();
			ancillariesPage.proceedToPayment();
			//paymentpages.enterCardDetails();
				 
		} catch (Exception e) {
			reports.logPass("Booking", "Error while doing Booking for One way DOM route");
			reports.logFail(e.getMessage(), "Unable to do Booking for One way DOM route...");
		}
	}
		
	@Test(enabled=false, description = "One way ME route booking")
	public void OneWayMERoute() throws Throwable {
		
		
		try {
			String origin1 ="DXB";
			String destination1 ="RUH";
			
			HomePage homePage = new HomePage(reports);
			PassengerDetailsPage passengerdetailspage = new PassengerDetailsPage(reports);
			SeatsAndExtras ancillariesPage = new SeatsAndExtras(reports);
			PaymentPage paymentpages = new PaymentPage(reports);
			homePage.acceptPrivacyCookies();
			homePage.changeCountryIndiaToSaudiArabia(GetTestData.searchCountryText);
			homePage.oneWayTripMethod(origin1, destination1);
			homePage.addAdultsPassenger(3);
			homePage.datepickerCalOW("December 2023" , "17");
			homePage.dontChangeBTNMethod();
			homePage.selectBusinessFlexFareCardOW();
			homePage.clickContToPassenger();
			passengerdetailspage.addAdult1PassengerDetails(1);
			passengerdetailspage.clickOnNextPassenger(1);
			passengerdetailspage.addAdult1PassengerDetails(2);
			passengerdetailspage.clickOnNextPassenger(2);
			passengerdetailspage.addAdult1PassengerDetails(3);
			passengerdetailspage.clickOnNextPassenger(3);
			passengerdetailspage.addAdult1PassengerDetails(4);
			passengerdetailspage.clickOnNextPassenger(4);
			passengerdetailspage.addAdult1PassengerDetails(5);
			passengerdetailspage.clickOnNextPassenger(5);
			passengerdetailspage.addAdult1PassengerDetails(6);
			passengerdetailspage.clickOnNextPassenger(6);
			passengerdetailspage.addAdult1PassengerDetails(7);
			passengerdetailspage.clickOnNextPassenger(7);
			passengerdetailspage.addAdult1PassengerDetails(8);
			passengerdetailspage.addPassengerConfirmBTN();
			passengerdetailspage.addContactDetails(GetTestData.countryCode, GetTestData.phoneNumber, GetTestData.email);
			//ancillariesPage.addBaggageOW();
			ancillariesPage.proceedToPayment();
			//paymentpages.enterCardDetails();
				 
		} catch (Exception e) {
			reports.logPass("Booking", "Error while doing Booking for One way ME route");
			reports.logFail(e.getMessage(), "Unable to do Booking for One way ME route...");
		}
		
		
		
	}
	
	
	@Test(priority= 1 , description = "One way Asia route booking")
	public void OneWayAsiaRoute() throws Throwable {
	
	
		try {
			
		String origin1 ="RUH";
		String destination1 ="JED";
		
		HomePage homePage = new HomePage(reports);
		PassengerDetailsPage passengerdetailspage = new PassengerDetailsPage(reports);
		SeatsAndExtras ancillariesPage = new SeatsAndExtras(reports);
		PaymentPage paymentpages = new PaymentPage(reports);
		homePage.acceptPrivacyCookies();
		homePage.changeCountryIndiaToSaudiArabia(GetTestData.searchCountryText);
		homePage.oneWayTripMethod(origin1, destination1);
		homePage.addAdultsPassenger(2);
		homePage.addChildrenPassenger(2);
		homePage.addInfantsPassenger(2);
		homePage.addIOSPassenger(2);
		homePage.selectGuestClass();
		homePage.datepickerCalOW("December 2023" , "7");
		Thread.sleep(3000);
		homePage.dontChangeBTNMethod();
	//	homePage.selectGuestSemiFlexFareCardOW();
		homePage.clickContToPassenger();
		passengerdetailspage.addAdultAndInfantPassengerDetails(1);
		passengerdetailspage.clickOnNextPassenger(1);
		passengerdetailspage.verifyingDetailsCont();
		passengerdetailspage.addAdultAndInfantPassengerDetails(2);
		passengerdetailspage.clickOnNextPassenger(2);
		passengerdetailspage.verifyingDetailsCont();
		passengerdetailspage.addChildPassengerDetails(1);
		passengerdetailspage.clickOnChildNextPassenger();
		passengerdetailspage.verifyingDetailsCont();
		passengerdetailspage.addChildPassengerDetails(2);
		passengerdetailspage.clickOnChildNextPassenger();
		passengerdetailspage.verifyingDetailsCont();
		passengerdetailspage.addINSDetails(1);
		passengerdetailspage.clickOnNextPassenger(1);
		passengerdetailspage.addINSDetails(2);
		passengerdetailspage.addPassengerConfirmBTN();
		passengerdetailspage.addContactDetails(GetTestData.countryCode, GetTestData.phoneNumber, GetTestData.email);
		ancillariesPage.addALTANFEETHIOW();
		ancillariesPage.proceedToPayment();
		//paymentpages.enterCardDetails();
			 
	} catch (Exception e) {
		reports.logPass("Booking", "Error while doing Booking for One way ME route");
		reports.logFail(e.getMessage(), "Unable to do Booking for One way ME route...");
	}
	
	
	
}
	
		@AfterMethod
	public void tearDown() {
			reports.endTest();

	}


}
