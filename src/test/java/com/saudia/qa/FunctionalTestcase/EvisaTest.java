package com.saudia.qa.FunctionalTestcase;


import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.pages.EvisaPage;
import com.saudia.qa.pages.FastTrackPage;
import com.saudia.qa.pages.FlightPage;
import com.saudia.qa.pages.HomePage;
import com.saudia.qa.pages.PassengerDetailsPage;
import com.saudia.qa.pages.PaymentPage;
import com.saudia.qa.pages.SeatsAndExtras;
import com.saudia.qa.util.GetTestData;
import com.saudia.qa.util.Log;
import com.saudia.qa.util.PreReqUtil;

public class EvisaTest extends TestBase {

	HomePage homePage;
	PassengerDetailsPage passengerdetailspage;
	PaymentPage paymentpages;
	PreReqUtil flightBooking;
	FlightPage flightPage;
	SeatsAndExtras seatAndExtras;
	FastTrackPage fastTrack;
	EvisaPage eVisa;

	@BeforeClass
	public void setup() throws Throwable {
		homePage = new HomePage(reports);
		passengerdetailspage = new PassengerDetailsPage(reports);
		paymentpages = new PaymentPage(reports);
		//homePage.acceptPrivacyCookies();
		//homePage.changeCountryIndiaToSaudiArabia(GetTestData.searchCountryText);
		flightBooking = new PreReqUtil();
		flightPage = new FlightPage(reports);
		seatAndExtras = new SeatsAndExtras(reports);
		eVisa = new EvisaPage(reports);
	}

	@BeforeMethod
	public void setupReport(Method m) throws Exception {
		reports.startTest(m.getName(), "ArchanaD", "E-Visa");
		homePage.clickOnSaudiaLogo();
	}

	@Test(priority = 1, description = "Add E-Visa for One way", enabled = true)
	public void addEVisaForOWINTL() {

		try {
			String depFlightClass = GetTestData.Departure_Flight_Class_OW_INTL;
			String depSubFareCard = GetTestData.Departure_Flight_SubClass_OW_INTL;

			flightBooking.applyForEvisa(homePage, passengerdetailspage, paymentpages, flightPage, depFlightClass,
					seatAndExtras, depSubFareCard, eVisa);

			seatAndExtras.verifyEVisaAdded(GetTestData.eVisa_totalAmount, 1);

			Log.info("Adding eVisaa for One Way trip flight booking [Internation Routes] is Successfull");
		} catch (Throwable e) {
			reports.logFail("One Way Flight Booking INTL Failed : ", e);
			Log.error("Error while doing One Way Flight INTL Booking", e);
		}
	}

	@Test(priority = 2, description = "Modify eVisa anscillary for One way", enabled = true)
	public void modifyEVisaForOW() {
		try {
			flightBooking.removeEvisa(seatAndExtras);
			seatAndExtras.verifyEVisaRemoved();

			Log.info("Modify eVisa TC is passed for One way");
		} catch (Throwable e) {
			Log.error("Error while Modifying eVisa TC for One way", e);
			reports.logFail("Modifying eVisa Testcase failed for One way", e);
		}
	}
	
	@Test(priority = 3, description = "Add E-Visa for Round Trip", enabled = false)
	public void addEVisaForRTINTL() {

		try {
						
			String depFlightClass = GetTestData.Departure_Flight_Class_RT;
			String depSubFareCard = GetTestData.Departure_Flight_SubClass_RT;
			String retFlightClass = GetTestData.Return_Flight_Class_RT;
			String retSubFareCard = GetTestData.Return_Flight_SubClass_RT;
			
			flightBooking.applyForEvisaRT(homePage, passengerdetailspage, paymentpages, flightPage, 
					seatAndExtras, eVisa,depFlightClass, depSubFareCard,retFlightClass, retSubFareCard);
			
			//seatAndExtras.verifyEVisaAdded(GetTestData.eVisa_totalAmount, 1);
			seatAndExtras.verifyEVisaAdded("SAR 231.00", 1);

			Log.info("Adding eVisaa for Round trip flight booking [Internation Routes] is Successfull");
		} catch (Throwable e) {
			reports.logFail("Round Trip Flight Booking INTL Failed : ", e);
			Log.error("Error while doing Round Trip Flight INTL Booking", e);
		}
	}

	@Test(priority = 4, description = "Modify eVisa anscillary for Round Trip", enabled = false)
	public void modifyEVisaForRT() {
		try {
			flightBooking.removeEvisa(seatAndExtras);
			seatAndExtras.verifyEVisaRemoved();

			Log.info("Modify eVisa TC is passed for Round Trip");
		} catch (Throwable e) {
			Log.error("Error while Modifying eVisa TC for Round Trip", e);
			reports.logFail("Modifying eVisa Testcase failed for Round Trip", e);
		}
	}

	@AfterMethod
	public void tearDown() {
		reports.endTest();
	}
}
