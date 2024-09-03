package com.saudia.qa.FunctionalTestcase;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.pages.CheckInPage;
import com.saudia.qa.pages.FlightPage;
import com.saudia.qa.pages.HomePage;
import com.saudia.qa.pages.MMBPage;
import com.saudia.qa.pages.PassengerDetailsPage;
import com.saudia.qa.pages.PaymentPage;
import com.saudia.qa.pages.SeatsAndExtras;
import com.saudia.qa.util.CommonMethodUtil;
import com.saudia.qa.util.CommonPageMethodUtil;
import com.saudia.qa.util.GetTestData;
import com.saudia.qa.util.Log;
import com.saudia.qa.util.PreReqUtil;

public class CheckInTest extends TestBase {

	HomePage homePage;
	PassengerDetailsPage passengerdetailspage;
	PaymentPage paymentpages;
	PreReqUtil preReq;
	FlightPage flightPage;
	SeatsAndExtras seatAndExtras;
	MMBPage mmb;
	CommonPageMethodUtil commonPageMethod;
	CheckInPage checkIn;

	@BeforeClass
	public void setup() throws Throwable {
		homePage = new HomePage(reports);
		passengerdetailspage = new PassengerDetailsPage(reports);
		paymentpages = new PaymentPage(reports);
		preReq = new PreReqUtil();
		flightPage = new FlightPage(reports);
		seatAndExtras = new SeatsAndExtras(reports);
		mmb = new MMBPage(reports);
		commonPageMethod = new CommonPageMethodUtil();
		checkIn = new CheckInPage(reports);
	}

	@BeforeMethod
	public void setupReport(Method m) throws Exception {
		reports.startTest(m.getName(), "ArchanaD", "Manage My Booking");
		homePage.clickOnSaudiaLogo();
	}

	@Test(priority = 1, description = "Check In FLight for OW", enabled = true)
	public void checkInFlight() {
		try {
			/*
			 * preReq.oneWayFlightBooking(homePage, passengerdetailspage, paymentpages,
			 * flightPage, depFlightClass, seatAndExtras, depSubFareCard);
			 * 
			 * homePage.clickOnSaudiaLogo();
			 */

			Thread.sleep(2000);
			homePage.searchPNRinCheckINTab(CommonMethodUtil.bookingReferenceRT, GetTestData.lastName);
			preReq.checkInFlight(1, checkIn, CommonMethodUtil.bookingReferenceRT);

			Log.info("Check In flight is Successfull");

		} catch (Throwable e) {
			reports.logFail("Error while CheckIn flight in MMB page", e);
			Log.error("Error while  CheckIn flight in MMB page", e);
		}
	}
	
	@Test(priority = 2, description = "Cancel flight", enabled = false)
	public void cancelFlight() {
		try {
			
			String depFlightClass = GetTestData.Departure_Flight_Class_RT;
			String depSubFareCard = GetTestData.Departure_Flight_SubClass_RT;
			String retFlightClass = GetTestData.Return_Flight_Class_RT;
			String retSubFareCard = GetTestData.Return_Flight_SubClass_RT;
			
			preReq.roundWayFlightBooking(homePage, passengerdetailspage, paymentpages, flightPage,
					depFlightClass, seatAndExtras, depSubFareCard, retFlightClass, retSubFareCard);
			
			homePage.clickOnSaudiaLogo();
			
		/*	homePage.searchPNRinMMBTab(CommonMethodUtil.bookingReferenceRT, GetTestData.lastName);
			mmb.cancelFlight();
			cancelTrip.passengerTab();
			cancelTrip.reviewTab();
			cancelTrip.verifyTripIsCanceled();*/
			
			Log.info("Cancel Trip route in MMB page");

		} catch (Throwable e) {
			reports.logFail("Error in Cancel Trip route in MMB page for OW: ", e);
			Log.error("Error in Cancel Trip route in MMB page  for OW ", e);
		}
	}
	
	
	@AfterMethod
	public void tearDown() {
		reports.endTest();
	}

}
