package com.saudia.qa.FunctionalTestcase;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.pages.FastTrackPage;
import com.saudia.qa.pages.FlightPage;
import com.saudia.qa.pages.HomePage;
import com.saudia.qa.pages.PassengerDetailsPage;
import com.saudia.qa.pages.PaymentPage;
import com.saudia.qa.pages.SeatsAndExtras;
import com.saudia.qa.util.GetTestData;
import com.saudia.qa.util.Log;
import com.saudia.qa.util.PreReqUtil;

public class FastTrackTest extends TestBase {
	HomePage homePage;
	PassengerDetailsPage passengerdetailspage;
	PaymentPage paymentpages;
	PreReqUtil flightBooking;
	FlightPage flightPage;
	SeatsAndExtras seatAndExtras;
	FastTrackPage fastTrack;
	int noOfBoundsMC;
	int noOfBoundRT = 2;
	int noOfBoundOW = 1;

	@BeforeClass
	public void setup() throws Throwable {
		homePage = new HomePage(reports);
		passengerdetailspage = new PassengerDetailsPage(reports);
		paymentpages = new PaymentPage(reports);
		flightBooking = new PreReqUtil();
		flightPage = new FlightPage(reports);
		seatAndExtras = new SeatsAndExtras(reports);
		fastTrack = new FastTrackPage(reports);
		//homePage.acceptPrivacyCookies();
		//homePage.changeCountryIndiaToSaudiArabia(GetTestData.searchCountryText);
	}

	@BeforeMethod
	public void setupReport(Method m) throws Exception {
		reports.startTest(m.getName(), "ArchanaD", "Seats and Extras Page - Fast Track");
		homePage.clickOnSaudiaLogo();
	}

	@Test(priority = 1, description = "Add Fast Track anscillary for One way", enabled = false)
	public void addFastTrackForOW() {
		try {
			String depFlightClass = GetTestData.Departure_Flight_Class_OW;
			String depSubFareCard = GetTestData.Departure_Flight_SubClass_OW;

			flightBooking.oneWayFlightBookingTillSeatsAndExtrasPage(homePage, passengerdetailspage, paymentpages,
					flightPage, depFlightClass, seatAndExtras, depSubFareCard);

		
			String[] addData = flightBooking.addFastTrack(noOfBoundOW, seatAndExtras, fastTrack);

			double subTotalAmount = Double.parseDouble(addData[0]);
			int availableFTFlights = Integer.parseInt(addData[1]);
			
			seatAndExtras.checkFastTrackOptionIsPresent();
			seatAndExtras.verifyFastTrackAdded("SAR " + String.format("%,.2f", subTotalAmount), availableFTFlights);

			Log.info("Add Fast Track TC is passed for One way");

		} catch (Throwable e) {
			reports.logFail("Adding Fast Track Testcase failed for One way : ", e);
			Log.error("Error while Adding Fast Track TC for One way", e);
		}
	}

	@Test(priority = 2, description = "Modify Fast Track anscillary for One way", enabled = false)
	public void modifyFastTrackForOW() {
		try {

			flightBooking.modifyFastTrack(noOfBoundOW, seatAndExtras, fastTrack);
			seatAndExtras.verifyFastTrackremoved();

			Log.info("Modify extra baggage TC is passed for One way");
		} catch (Throwable e) {
			Log.error("Error while Modifying Extra Baggage TC for One way", e);
			reports.logFail("Modifying Extra Baggage Testcase failed for One way", e);
		}
	}

	@Test(priority = 3, description = "Add Fast Track for Round Trip", enabled = false)
	public void addFastTrackForRT() {
		try {
			String depFlightClass = GetTestData.Departure_Flight_Class_RT;
			String depSubFareCard = GetTestData.Departure_Flight_SubClass_RT;
			String retFlightClass = GetTestData.Return_Flight_Class_RT;
			String retSubFareCard = GetTestData.Return_Flight_SubClass_RT;

			flightBooking.roundWayFlightBookingTillSeatsAndExtrasPage(homePage, passengerdetailspage, paymentpages,
					flightPage, depFlightClass, seatAndExtras, depSubFareCard, retFlightClass, retSubFareCard);

			String[] addData = flightBooking.addFastTrack(noOfBoundRT, seatAndExtras, fastTrack);

			double subTotalAmount = Double.parseDouble(addData[0]);
			int availableFTFlights = Integer.parseInt(addData[1]);
			
			seatAndExtras.checkFastTrackOptionIsPresent();
			seatAndExtras.verifyFastTrackAdded("SAR " + String.format("%,.2f", subTotalAmount), availableFTFlights);

			Log.info("Add Fast Track TC is passed for Round Trip");

		} catch (Throwable e) {
			Log.error("Error while Adding Fast Track TC for Round trip ", e);
			reports.logFail("Adding Fast Track Testcase failed for Round trip : ", e);
		}
	}

	@Test(priority = 4, description = "Modify Fast Track anscillary for Round Trip", enabled = false)
	public void modifyFastTrackForRT() {
		try {

			flightBooking.modifyFastTrack(noOfBoundRT, seatAndExtras, fastTrack);
			seatAndExtras.verifyFastTrackremoved();

			Log.info("Modify extra baggage TC is passed for Round Trip");
		} catch (Throwable e) {
			Log.error("Error while Modifying Extra Baggage TC for Round Trip", e);
			reports.logFail("Modifying Extra Baggage Testcase failed for Round Trip", e);
		}
	}

	@Test(priority = 5, description = "Add Fast Track for Multicity Trip", enabled = true)
	public void addFastTrackForMC() {
		try {
			noOfBoundsMC = 3;
			flightBooking.multiCityFlightBookingTillSeatsandExtras(homePage, passengerdetailspage, paymentpages,
					flightPage, seatAndExtras, noOfBoundsMC);

			String[] addData = flightBooking.addFastTrack(noOfBoundsMC, seatAndExtras, fastTrack);

			double subTotalAmount = Double.parseDouble(addData[0]);
			int availableFTFlights = Integer.parseInt(addData[1]);

			seatAndExtras.checkFastTrackOptionIsPresent();
			seatAndExtras.verifyFastTrackAdded("SAR " + String.format("%,.2f", subTotalAmount), availableFTFlights);

			Log.info("Add Fast Track TC is passed for Multicity Trip");

		} catch (Throwable e) {
			Log.error("Error while Adding Fast Track TC for Multicity trip ", e);
			reports.logFail("Adding Fast Track Testcase failed for Multicity trip : ", e);
		}
	}

	@Test(priority = 6, description = "Modify Fast Track anscillary for Multicity Trip", enabled = true)
	public void modifyFastTrackForMC() {
		try {
			flightBooking.modifyFastTrack(noOfBoundsMC, seatAndExtras, fastTrack);
			seatAndExtras.verifyFastTrackremoved();

			Log.info("Modify extra baggage TC is passed for Round Trip");
		} catch (Throwable e) {
			Log.error("Error while Modifying Extra Baggage TC for Round Trip", e);
			reports.logFail("Modifying Extra Baggage Testcase failed for Round Trip", e);
		}
	}

	@AfterMethod
	public void tearDown() {
		reports.endTest();
	}
}
