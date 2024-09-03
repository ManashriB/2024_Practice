
package com.saudia.qa.FunctionalTestcase;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.pages.AltanfeethiVIPServicePage;
import com.saudia.qa.pages.FlightPage;
import com.saudia.qa.pages.HomePage;
import com.saudia.qa.pages.PassengerDetailsPage;
import com.saudia.qa.pages.PaymentPage;
import com.saudia.qa.pages.SeatsAndExtras;
import com.saudia.qa.util.GetTestData;
import com.saudia.qa.util.Log;
import com.saudia.qa.util.PreReqUtil;

public class AltanfeethiVIPServiceTest extends TestBase {
	HomePage homePage;
	PassengerDetailsPage passengerdetailspage;
	PaymentPage paymentpages;
	PreReqUtil flightBooking;
	FlightPage flightPage;
	SeatsAndExtras seatAndExtras;
	AltanfeethiVIPServicePage altanfeethiVIPService;
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
		altanfeethiVIPService = new AltanfeethiVIPServicePage(reports);
		//homePage.acceptPrivacyCookies();
		//homePage.changeCountryIndiaToSaudiArabia(GetTestData.searchCountryText);
	}

	@BeforeMethod
	public void setupReport(Method m) throws Exception {
		reports.startTest(m.getName(), "ArchanaD", "Seats and Extras Page -Altanfeethi VIP Service");
		homePage.clickOnSaudiaLogo();
	}

	@Test(priority = 1, description = "Add Altanfeethi VIP Service for One way", enabled = false)
	public void addAltanfeethiForOW() {
		
		try {
			String depFlightClass = GetTestData.Departure_Flight_Class_OW;
			String depSubFareCard = GetTestData.Departure_Flight_SubClass_OW;

			flightBooking.oneWayFlightBookingTillSeatsAndExtrasPage(homePage, passengerdetailspage, paymentpages,
					flightPage, depFlightClass, seatAndExtras, depSubFareCard);

			String[] addData = flightBooking.addALTVIPService(noOfBoundOW, seatAndExtras, altanfeethiVIPService);

			double subTotalAmount = Double.parseDouble(addData[0]);
			int availableALTFlights = Integer.parseInt(addData[1]);
			
			seatAndExtras.checkAltanfeethiVIPServiceOptionIsPresent();
			seatAndExtras.verifyAltanfeethiAdded("SAR " + String.format("%,.2f", subTotalAmount), availableALTFlights);
			Log.info("Add Altanfeethi VIP Service TC is passed for One way");
		} catch (Throwable e) {
			reports.logFail("Adding Altanfeethi VIP Service Testcase failed for One way : ", e);
			Log.error("Error while Adding Altanfeethi VIP Service Testcase for One way", e);
		}
	}

	@Test(priority = 2, description = "Modify Altanfeethi VIP Service anscillary for One way", enabled = false)
	public void modifyAltanfeethiForOW() {
		try {

			flightBooking.modifyALTVIPService(noOfBoundOW, seatAndExtras, altanfeethiVIPService);
			seatAndExtras.verifyAltanfeethiRemoved();
			Log.info("Modify Altanfeethi VIP Service TC is passed for One way");
		} catch (Throwable e) {
			Log.error("Error while Modifying Altanfeethi VIP Service TC for One way", e);
			reports.logFail("Modifying Altanfeethi VIP Service Testcase failed for One way", e);
		}
	}

	@Test(priority = 2, description = "Add Altanfeethi VIP Service for Round Trip", enabled = true)
	public void addAltanfeethiForRT() {
		try {
			String depFlightClass = GetTestData.Departure_Flight_Class_RT;
			String depSubFareCard = GetTestData.Departure_Flight_SubClass_RT;
			String retFlightClass = GetTestData.Return_Flight_Class_RT;
			String retSubFareCard = GetTestData.Return_Flight_SubClass_RT;

			flightBooking.roundWayFlightBookingTillSeatsAndExtrasPage(homePage, passengerdetailspage, paymentpages,
					flightPage, depFlightClass, seatAndExtras, depSubFareCard, retFlightClass, retSubFareCard);

			String[] addData = flightBooking.addALTVIPService(noOfBoundRT, seatAndExtras, altanfeethiVIPService);

			double subTotalAmount = Double.parseDouble(addData[0]);
			int availableALTFlights = Integer.parseInt(addData[1]);

			seatAndExtras.checkAltanfeethiVIPServiceOptionIsPresent();
			seatAndExtras.verifyAltanfeethiAdded("SAR " + String.format("%,.2f", subTotalAmount), availableALTFlights);

			Log.info("Add Altanfeethi VIP Service TC is passed for Round trip");

		} catch (Throwable e) {
			Log.error("Error while Adding Altanfeethi VIP Service TC for Round trip ", e);
			reports.logFail("Adding Altanfeethi VIP Service Testcase failed for Round trip : ", e);
		}
	}

	@Test(priority = 4, description = "Modify Altanfeethi VIP Service anscillary for Round Trip", enabled = false)
	public void modifyAltanfeethiForRT() {
		try {

			flightBooking.modifyALTVIPService(noOfBoundRT, seatAndExtras, altanfeethiVIPService);
			seatAndExtras.verifyAltanfeethiRemoved();

			Log.info("Modify Altanfeethi VIP Service TC is passed for Round Trip");
		} catch (Throwable e) {
			Log.error("Error while Modifying Altanfeethi VIP Service TC for Round Trip", e);
			reports.logFail("Modifying EAltanfeethi VIP Service Testcase failed for Round Trip", e);
					
		}		
	}

	@Test(priority = 5, description = "Add Altanfeethi VIP Service for Multicity Trip", enabled = true)
	public void addAltanfeethiForMC() {
		try {
			flightBooking.multiCityFlightBookingTillSeatsandExtras(homePage, passengerdetailspage, paymentpages,
					flightPage, seatAndExtras, noOfBoundsMC);

			String[] addData = flightBooking.addALTVIPService(noOfBoundsMC, seatAndExtras, altanfeethiVIPService);

			double subTotalAmount = Double.parseDouble(addData[0]);
			int availableALTFlights = Integer.parseInt(addData[1]);

			seatAndExtras.checkAltanfeethiVIPServiceOptionIsPresent();
			seatAndExtras.verifyAltanfeethiAdded("SAR " + String.format("%,.2f", subTotalAmount), availableALTFlights);

			Log.info("Add Altanfeethi VIP Service TC is passed for Multicity trip");

		} catch (Throwable e) {
			Log.error("Error while Adding Altanfeethi VIP Service TC for Multicity trip ", e);
			reports.logFail("Adding Altanfeethi VIP Service Testcase failed for Multicity trip : ", e);
		}
	}

	@Test(priority = 6, description = "Modify Altanfeethi VIP Service anscillary for Multicity Trip", enabled = true)
	public void modifyAltanfeethiForMC() {
		try {
			flightBooking.modifyALTVIPService(noOfBoundsMC, seatAndExtras, altanfeethiVIPService);
			seatAndExtras.verifyAltanfeethiRemoved();
			Log.info("Modify Altanfeethi VIP Service TC is passed for Multicity trip");

		} catch (Throwable e) {
			Log.error("Error while Modifying Altanfeethi VIP Service TC for Multicity trip ", e);
			reports.logFail("Modifying Altanfeethi VIP Service Testcase failed for Multicity trip : ", e);
		}
	}

	@AfterMethod
	public void tearDown() {
		reports.endTest();
	}
}
