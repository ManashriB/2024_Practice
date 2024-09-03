package com.saudia.qa.FunctionalTestcase;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.pages.FlightPage;
import com.saudia.qa.pages.HomePage;
import com.saudia.qa.pages.PassengerDetailsPage;
import com.saudia.qa.pages.PaymentPage;
import com.saudia.qa.pages.SeatsAndExtras;
import com.saudia.qa.util.CommonPageMethodUtil;
import com.saudia.qa.util.GetTestData;
import com.saudia.qa.util.Log;
import com.saudia.qa.util.PreReqUtil;

@Listeners(com.saudia.qa.listeners.TestListener.class)

public class BookingTest extends TestBase {
	// protected Utilities utils;
	ArrayList<String> values = new ArrayList<>();
	protected String pnr = null;
	HomePage homePage;
	PassengerDetailsPage passengerdetailspage;
	PaymentPage paymentpages;
	PreReqUtil flightBooking;
	FlightPage flightPage;
	SeatsAndExtras seatAndExtras;
	CommonPageMethodUtil commonPageMethod;

	/*
	 * public BookingTest() { super(); }
	 */
	
	@BeforeClass
	public void setup() throws Throwable {
		homePage = new HomePage(reports);
		passengerdetailspage = new PassengerDetailsPage(reports);
		paymentpages = new PaymentPage(reports);
		// homePage.acceptPrivacyCookies();
		// homePage.changeCountryIndiaToSaudiArabia(GetTestData.searchCountryText);
		flightBooking = new PreReqUtil();
		flightPage = new FlightPage(reports);
		seatAndExtras = new SeatsAndExtras(reports);
		commonPageMethod = new CommonPageMethodUtil();
	}

	@BeforeMethod
	public void setup(Method m) throws Throwable {
		reports.startTest(m.getName(), "ArchanaD", "Flight Booking");
		homePage.clickOnSaudiaLogo();
	}
	
	@Test(priority = 1, description = "One Way Flight Booking" , enabled = false)
	public void OneWayFlightBooking() throws Throwable {

		try {
			String depFlightClass = GetTestData.Departure_Flight_Class_OW;
			String depSubFareCard = GetTestData.Departure_Flight_SubClass_OW;
			flightBooking.oneWayFlightBooking(homePage, passengerdetailspage, paymentpages, flightPage,
					depFlightClass, seatAndExtras, depSubFareCard);

			Log.info("One Way trip flight booking is Test Successfull");
		} catch (Throwable e) {
			reports.logFail("One Way Flight Booking Failed : ", e);
			Log.error("Error while doing One Way Flight Booking", e);
		}
		
		
	}

	@Test(priority = 2, description = "Round Way Flight Booking" , enabled = true)	
	public void RoundWayFlightBooking() throws Throwable {

		try {
			String depFlightClass = GetTestData.Departure_Flight_Class_RT;
			String depSubFareCard = GetTestData.Departure_Flight_SubClass_RT;
			String retFlightClass = GetTestData.Return_Flight_Class_RT;
			String retSubFareCard = GetTestData.Return_Flight_SubClass_RT;
			
			flightBooking.roundWayFlightBooking(homePage, passengerdetailspage, paymentpages, flightPage,
					depFlightClass, seatAndExtras, depSubFareCard, retFlightClass, retSubFareCard);
			
			Log.info("Round trip flight booking is Test Successfull");
		} catch (Throwable e) {
			reports.logFail("Round Way Flight Booking Failed : ", e);
			Log.error("Error while doing Round Way Flight Booking", e);
		}
	}
	
	@Test(priority = 3, description = "Multicity Flight Booking for two bounds", enabled = false)
	public void MultiCityTwoBoundFlightBooking() {
		try {

			int noOfBounds = 2;
			flightBooking.multiCityFlightBooking(homePage, passengerdetailspage, paymentpages, flightPage,
					seatAndExtras, noOfBounds);
			// reports.AssertTrue(flightPage.verifyFlightDetailsPageIsOpened(), "Flight
			// details page is not opened");
			Log.info("Multicity flight booking for two bounds is Test Successfull");

		} catch (Throwable e) {
			reports.logFail("Multicity Booking for two bounds Failed : ", e);
			Log.error("Error while doing Multicity Flight for two bounds Booking", e);
		}
	}

	@Test(priority = 4, description = "Multicity Flight Booking for three bounds", enabled = true)
	public void MultiCityThreeBoundFlightBooking() {
		try {

			int noOfBounds = 3;
			flightBooking.multiCityFlightBooking(homePage, passengerdetailspage, paymentpages, flightPage,
					seatAndExtras, noOfBounds);
			// reports.AssertTrue(flightPage.verifyFlightDetailsPageIsOpened(), "Flight
			// details page is not opened");
			Log.info("Multicity flight booking for three bounds is Test Successfull");

		} catch (Throwable e) {
			reports.logFail("Multicity Booking for three bounds Failed : ", e);
			Log.error("Error while doing Multicity Flight for three bounds Booking", e);
		}
	}
	
	@Test(priority = 5, description = "Multicity Flight Booking for four bounds", enabled = false)
	public void MultiCityFourBoundFlightBooking() {
		try {

			int noOfBounds = 4;
			flightBooking.multiCityFlightBooking(homePage, passengerdetailspage, paymentpages, flightPage,
					seatAndExtras, noOfBounds);
			// reports.AssertTrue(flightPage.verifyFlightDetailsPageIsOpened(), "Flight
			// details page is not opened");
			Log.info("Multicity flight booking for four bounds is Test Successfull");

		} catch (Throwable e) {
			reports.logFail("Multicity Booking for four bounds Failed : ", e);
			Log.error("Error while doing Multicity Flight for four bounds Booking", e);
		}
	}

	@Test(priority = 6, description = "Multicity Flight Booking for Five bounds", enabled = false)
	public void MultiCityFiveBoundFlightBooking() {
		try {

			int noOfBounds = 5;
			flightBooking.multiCityFlightBooking(homePage, passengerdetailspage, paymentpages, flightPage,
					seatAndExtras, noOfBounds);
			Log.info("Multicity flight booking for four bounds is Test Successfull");

		} catch (Throwable e) {
			reports.logFail("Multicity Booking for five bounds Failed : ", e);
			Log.error("Error while doing Multicity Flight for five bounds Booking", e);
		}
	}

	@Test(priority = 7, description = "Multicity Flight Booking for Six bounds", enabled = false)
	public void MultiCitySixBoundFlightBooking() {
		try {

			int noOfBounds = 6;
			flightBooking.multiCityFlightBooking(homePage, passengerdetailspage, paymentpages, flightPage,
					seatAndExtras, noOfBounds);
			Log.info("Multicity flight booking for six bounds is Test Successfull");

		} catch (Throwable e) {
			reports.logFail("Multicity Booking for six bounds Failed : ", e);
			Log.error("Error while doing Multicity Flight for six bounds Booking", e);
		}
	}

	@AfterMethod
	public void tearDown() {
		reports.endTest();
	}

}
