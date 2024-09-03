
package com.saudia.qa.FunctionalTestcase;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.pages.FlightPage;
import com.saudia.qa.pages.HomePage;
import com.saudia.qa.pages.PassengerDetailsPage;
import com.saudia.qa.pages.PaymentPage;
import com.saudia.qa.pages.SeatSelectionPage;
import com.saudia.qa.pages.SeatsAndExtras;
import com.saudia.qa.util.CommonPageMethodUtil;
import com.saudia.qa.util.GetTestData;
import com.saudia.qa.util.Log;
import com.saudia.qa.util.PreReqUtil;

public class SeatSelectionTest extends TestBase {
	HomePage homePage;
	PassengerDetailsPage passengerdetailspage;
	PaymentPage paymentpages;
	PreReqUtil flightBooking;
	FlightPage flightPage;
	SeatsAndExtras seatAndExtras;
	SeatSelectionPage seatSelection;
	CommonPageMethodUtil commonPageMethodUtil;
	int noOfBoundOW = 1;
	int noOfBoundRT = 2;
	int noOfBoundsMC = 3;

	@BeforeClass
	public void setup() throws Throwable {
		homePage = new HomePage(reports);
		passengerdetailspage = new PassengerDetailsPage(reports);
		paymentpages = new PaymentPage(reports);
		flightBooking = new PreReqUtil();
		flightPage = new FlightPage(reports);
		seatAndExtras = new SeatsAndExtras(reports);
		seatSelection = new SeatSelectionPage(reports);
		commonPageMethodUtil = new CommonPageMethodUtil();
		//homePage.acceptPrivacyCookies();
		//homePage.changeCountryIndiaToSaudiArabia(GetTestData.searchCountryText);
	}

	@BeforeMethod
	public void setupReport(Method m) {
		reports.startTest(m.getName(), "ArchanaD", "Seats and Extras Page -Seat Selection Service");
	}

	@Test(priority = 1, description = "Seat Selection for One way", enabled = true)
	public void seatSelectionForOW() {

		try {
			String depFlightClass = GetTestData.Departure_Flight_Class_OW;
			String depSubFareCard = GetTestData.Departure_Flight_SubClass_OW;

			flightBooking.oneWayFlightBookingTillSeatsAndExtrasPage(homePage, passengerdetailspage, paymentpages,
					flightPage, depFlightClass, seatAndExtras, depSubFareCard);

			String[] addData = flightBooking.SeatSelection(noOfBoundOW, seatAndExtras, seatSelection);

			double subTotalAmount = Double.parseDouble(addData[0]);
			int availableSeat = Integer.parseInt(addData[1]);

			seatAndExtras.verifySeatSelected("SAR " + String.format("%,.2f", subTotalAmount), availableSeat);
			Log.info("Seat Selection TC is passed for One way");
		} catch (Throwable e) {
			reports.logFail("Seat Selection Testcase failed for One way : ", e);
			Log.error("Error while Selecting Seat Testcase for One way", e);
		}
	}

	@Test(priority = 2, description = "Modify Seat Selection anscillary for One way", enabled = false)
	public void modifySeatSelectedForOW() {
		try {

			flightBooking.modifySelectedSeatService(noOfBoundOW, seatAndExtras, seatSelection);
			seatAndExtras.verifySelecetdSeatRemoved();
			Log.info("Modify Seat Selection TC is passed for One way");
		} catch (Throwable e) {
			Log.error("Error while Modifying Seat Selection TC for One way", e);
			reports.logFail("Modifying Seat Selection Testcase failed for One way", e);
		}
	}

	@Test(priority = 2, description = "Seat Selection for Round Trip", enabled = false)
	public void seatSelectionForRT() {

		try {
			String depFlightClass = GetTestData.Departure_Flight_Class_RT;
			String depSubFareCard = GetTestData.Departure_Flight_SubClass_RT;
			String retFlightClass = GetTestData.Return_Flight_Class_RT;
			String retSubFareCard = GetTestData.Return_Flight_SubClass_RT;

			flightBooking.roundWayFlightBookingTillSeatsAndExtrasPage(homePage, passengerdetailspage, paymentpages,
					flightPage, depFlightClass, seatAndExtras, depSubFareCard, retFlightClass, retSubFareCard);

			String[] addData = flightBooking.SeatSelection(noOfBoundRT, seatAndExtras, seatSelection);

			double subTotalAmount = Double.parseDouble(addData[0]);
			int availableSeat = Integer.parseInt(addData[1]);

			seatAndExtras.verifySeatSelected("SAR " + String.format("%,.2f", subTotalAmount), availableSeat);
			Log.info("Seat Selection TC is passed for Round Trip");
		} catch (Throwable e) {
			reports.logFail("Seat Selection Testcase failed for Round Trip : ", e);
			Log.error("Error while Selecting Seat Testcase forRound Trip", e);
		}
	}

	@Test(priority = 4, description = "Modify Seat Selection anscillary for Round Trip", enabled = false)
	public void modifyAltanfeethiForRT() {
		try {

			flightBooking.modifySelectedSeatService(noOfBoundRT, seatAndExtras, seatSelection);
			seatAndExtras.verifySelecetdSeatRemoved();

			Log.info("Modify Seat Selection TC is passed for Round Trip");
		} catch (Throwable e) {
			Log.error("Error while Modifying Seat Selection TC for Round Trip", e);
			reports.logFail("Modifying ESeat Selection Testcase failed for Round Trip", e);

		}
	}

	@Test(priority = 5, description = "Add Seat Selection for Multicity Trip", enabled = false)
	public void seatSelectedForMC() {

		try {
			flightBooking.multiCityFlightBookingTillSeatsandExtras(homePage, passengerdetailspage, paymentpages,
					flightPage, seatAndExtras, noOfBoundsMC);

			String[] addData = flightBooking.SeatSelection(noOfBoundsMC, seatAndExtras, seatSelection);

			double subTotalAmount = Double.parseDouble(addData[0]);
			int availableSeat = Integer.parseInt(addData[1]);

			seatAndExtras.verifySeatSelected("SAR " + String.format("%,.2f", subTotalAmount), availableSeat);
			Log.info("Seat Selection TC is passed for One way");
		} catch (Throwable e) {
			reports.logFail("Seat Selection Testcase failed for One way : ", e);
			Log.error("Error while Selecting Seat Testcase for One way", e);
		}
	}

	@Test(priority = 6, description = "Modify Seat Selection anscillary for Multicity Trip", enabled = false)
	public void modifyAltanfeethiForMC() {
		try {
			flightBooking.modifySelectedSeatService(noOfBoundsMC, seatAndExtras, seatSelection);
			seatAndExtras.verifySelecetdSeatRemoved();
			Log.info("Modify Seat Selection TC is passed for Multicity trip");

		} catch (Throwable e) {
			Log.error("Error while Modifying Seat Selection TC for Multicity trip ", e);
			reports.logFail("Modifying Seat Selection Testcase failed for Multicity trip : ", e);
		}
	}

	@AfterMethod
	public void tearDown() {
		reports.endTest();
	}
}
