package com.saudia.qa.FunctionalTestcase;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.pages.ExtraBaggagePage;
import com.saudia.qa.pages.FlightPage;
import com.saudia.qa.pages.HomePage;
import com.saudia.qa.pages.PassengerDetailsPage;
import com.saudia.qa.pages.PaymentPage;
import com.saudia.qa.pages.SeatsAndExtras;
import com.saudia.qa.util.GetTestData;
import com.saudia.qa.util.Log;
import com.saudia.qa.util.PreReqUtil;

public class ExtraBaggageTest extends TestBase {

	HomePage homePage;
	PassengerDetailsPage passengerdetailspage;
	PaymentPage paymentpages;
	PreReqUtil flightBooking;
	FlightPage flightPage;
	SeatsAndExtras seatAndExtras;
	ExtraBaggagePage extraBaggage;
	String totalBagsAddedAmountOW;
	String totalBagsAddedAmountRT;
	int noOfBoundsMC;

	@BeforeClass
	public void setup() throws Throwable {
		homePage = new HomePage(reports);
		passengerdetailspage = new PassengerDetailsPage(reports);
		paymentpages = new PaymentPage(reports);
		flightBooking = new PreReqUtil();
		flightPage = new FlightPage(reports);
		seatAndExtras = new SeatsAndExtras(reports);
		extraBaggage = new ExtraBaggagePage(reports);
		//homePage.acceptPrivacyCookies();
		//homePage.changeCountryIndiaToSaudiArabia(GetTestData.searchCountryText);
	}

	@BeforeMethod
	public void setupReport(Method m) throws Exception {
		reports.startTest(m.getName(), "ArchanaD", "Seats and Extras Page");
		homePage.clickOnSaudiaLogo();
	}

	@Test(priority = 1, description = "Add Extra 4 Baggage for Departure Flight for One way", enabled = false)
	public void addExtraBaggageForOW() {
		try {
			String depFlightClass = GetTestData.Departure_Flight_Class_OW;
			String depSubFareCard = GetTestData.Departure_Flight_SubClass_OW;
			
			flightBooking.oneWayFlightBookingTillSeatsAndExtrasPage(homePage, passengerdetailspage, paymentpages,
					flightPage, depFlightClass, seatAndExtras, depSubFareCard);

			String[] addedBagsData = flightBooking.addExtraBaggage(1, seatAndExtras, extraBaggage);
			int totalBags = Integer.parseInt(addedBagsData[0]);

			// String totalAmount = String.format("%.2f", addedBagsData.split(":")[1]);
			totalBagsAddedAmountOW = addedBagsData[1];
			seatAndExtras.verifyExtraBagsAreAdded(totalBags, totalBagsAddedAmountOW);

			Log.info("Add extra baggage TC is passed for One way");

		} catch (Throwable e) {
			reports.logFail("Adding Extra Baggage Testcase failed for One way : ", e);
			Log.error("Error while Adding Extra Baggage TC for One way", e);
		}
	}

	@Test(priority = 2, description = "Modify ExtraBaggage - Remove 4 Baggage for Departure Flight for One way", enabled = false)
	public void modifyExtraBaggageForOW() {
		try {

			int noOfBagsRemove = Integer.parseInt(GetTestData.ExtraBags_MAX_Allowed_Count);
			String modifiedData = flightBooking.modifyExtraBaggage(1, seatAndExtras, extraBaggage);
			int totalBags = Integer.parseInt(modifiedData.split(":")[0]);
			String totalAmount = modifiedData.split(":")[1];

			if (totalBags > 0) {
				seatAndExtras.verifyExtraBagsAreAdded(totalBags, totalAmount);
			} else {
				reports.logPass("Verify Extra Baggages count and amount in 'Seats and Extras' Page. Total "
						+ noOfBagsRemove + " baggages are removed of amount " + totalBagsAddedAmountOW);
			}

			Log.info("Modify extra baggage TC is passed for One way");
		} catch (Throwable e) {
			Log.error("Error while Modifying Extra Baggage TC for One way", e);
			reports.logFail("Modifying Extra Baggage Testcase failed for One way", e);
		}
	}

	@Test(priority = 3, description = "Add Extra 4 Baggage for Departure and 4 for Return Flight for Round Trip", enabled = false)
	public void addExtraBaggageForRT() {
		try {
			String depFlightClass = GetTestData.Departure_Flight_Class_RT;
			String depSubFareCard = GetTestData.Departure_Flight_SubClass_RT;
			String retFlightClass = GetTestData.Return_Flight_Class_RT;
			String retSubFareCard = GetTestData.Return_Flight_SubClass_RT;

			flightBooking.roundWayFlightBookingTillSeatsAndExtrasPage(homePage, passengerdetailspage, paymentpages,
					flightPage, depFlightClass, seatAndExtras, depSubFareCard, retFlightClass, retSubFareCard);

			String[] addedBagsData = flightBooking.addExtraBaggage(2, seatAndExtras, extraBaggage);
			int totalBags = Integer.parseInt(addedBagsData[0]);
			totalBagsAddedAmountRT = addedBagsData[1];

			seatAndExtras.verifyExtraBagsAreAdded(totalBags, totalBagsAddedAmountRT);

			Log.info("Add extra baggage TC is passed for Round Trip");

		} catch (Throwable e) {
			Log.error("Error while Adding Extra Baggage TC for Round trip ", e);
			reports.logFail("Adding Extra Baggage Testcase failed for Round trip : ", e);
		}
	}

	@Test(priority = 4, description = "Modify ExtraBaggage - Remove 4 Baggage for Departure and 4 for Return Flight for Round Trip", enabled = false)
	public void modifyExtraBaggageForRT() {
		try {

			int noOfBagsRemove = Integer.parseInt(GetTestData.ExtraBags_MAX_Allowed_Count);
			String modifiedData = flightBooking.modifyExtraBaggage(2, seatAndExtras, extraBaggage);
			int totalBags = Integer.parseInt(modifiedData.split(":")[0]);
			String totalAmount = modifiedData.split(":")[1];

			// int totalBags = totalBagsReturning + totalBagsRemovedDeparting;
			if (totalBags > 0) {
				seatAndExtras.verifyExtraBagsAreAdded(totalBags, totalAmount);
			} else {
				reports.logPass("Verify Extra Baggages count and amount in 'Seats and Extras' Page. Total "
						+ (noOfBagsRemove * 2) + " baggages are removed of amount " + totalBagsAddedAmountRT);
			}

			Log.info("Modify extra baggage TC is passed for Round trip");
		} catch (Throwable e) {
			Log.error("Error while Modifying Extra Baggage TC for Round trip", e);
			reports.logFail("Modifying Extra Baggage Testcase failed for Round trip ", e);
		}
	}

	@Test(priority = 5, description = "Add Extra 4 Baggage for Multicity Trip", enabled = true)
	public void addExtraBaggageForMC() {
		try {
			noOfBoundsMC = 3;
			flightBooking.multiCityFlightBookingTillSeatsandExtras(homePage, passengerdetailspage, paymentpages, flightPage,
					seatAndExtras, noOfBoundsMC);
			
			String[] addedBagsData = flightBooking.addExtraBaggage(noOfBoundsMC, seatAndExtras, extraBaggage);
			int totalBags = Integer.parseInt(addedBagsData[0]);
			totalBagsAddedAmountRT = addedBagsData[1];

			seatAndExtras.verifyExtraBagsAreAdded(totalBags, totalBagsAddedAmountRT);

			Log.info("Add extra baggage TC is passed for Multicity Trip");

		} catch (Throwable e) {
			Log.error("Error while Adding Extra Baggage TC for Multicity Trip ", e);
			reports.logFail("Adding Extra Baggage Testcase failed for Multicity Trip : ", e);
		}
	}
	
	@Test(priority = 6, description = "Modify ExtraBaggage - Remove 4 Baggage for Multicity Trip", enabled = true)
	public void modifyExtraBaggageForMC() {
		try {

			int noOfBagsRemove = Integer.parseInt(GetTestData.ExtraBags_MAX_Allowed_Count);
			String modifiedData = flightBooking.modifyExtraBaggage(noOfBoundsMC, seatAndExtras, extraBaggage);
			int totalBags = Integer.parseInt(modifiedData.split(":")[0]);
			String totalAmount = modifiedData.split(":")[1];

			// int totalBags = totalBagsReturning + totalBagsRemovedDeparting;
			if (totalBags > 0) {
				seatAndExtras.verifyExtraBagsAreAdded(totalBags, totalAmount);
			} else {
				reports.logPass("Verify Extra Baggages count and amount in 'Seats and Extras' Page. Total "
						+ (noOfBagsRemove * noOfBoundsMC) + " baggages are removed of amount " + totalBagsAddedAmountRT);
			}

			Log.info("Modify extra baggage TC is passed for Multicity Trip");
		} catch (Throwable e) {
			Log.error("Error while Modifying Extra Baggage TC for Multicity Trip", e);
			reports.logFail("Modifying Extra Baggage Testcase failed for Multicity Trip ", e);
		}
	}
	@AfterMethod
	public void tearDown() {
		reports.endTest();
	}

}
