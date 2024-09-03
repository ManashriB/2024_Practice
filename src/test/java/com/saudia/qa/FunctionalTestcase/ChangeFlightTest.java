package com.saudia.qa.FunctionalTestcase;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.pages.CancelTripPage;
import com.saudia.qa.pages.ChangeFlightPage;
import com.saudia.qa.pages.FlightPage;
import com.saudia.qa.pages.HomePage;
import com.saudia.qa.pages.MMBPage;
import com.saudia.qa.pages.PassengerDetailsPage;
import com.saudia.qa.pages.PaymentPage;
import com.saudia.qa.pages.SeatsAndExtras;
import com.saudia.qa.util.CommonMethodUtil;
import com.saudia.qa.util.CommonPageMethodUtil;
import com.saudia.qa.util.GetTestData;
import com.saudia.qa.util.LayoutHeader;
import com.saudia.qa.util.Log;
import com.saudia.qa.util.PreReqUtil;

public class ChangeFlightTest extends TestBase {

	HomePage homePage;
	PassengerDetailsPage passengerdetailspage;
	PaymentPage paymentpages;
	PreReqUtil preReq;
	FlightPage flightPage;
	SeatsAndExtras seatAndExtras;
	MMBPage mmb;
	ChangeFlightPage changeFlight;
	CommonPageMethodUtil commonPageMethod;
	CancelTripPage cancelTrip;

	@BeforeClass
	public void setup() throws Throwable {
		homePage = new HomePage(reports);
		passengerdetailspage = new PassengerDetailsPage(reports);
		paymentpages = new PaymentPage(reports);
		preReq = new PreReqUtil();
		flightPage = new FlightPage(reports);
		seatAndExtras = new SeatsAndExtras(reports);
		mmb = new MMBPage(reports);
		changeFlight = new ChangeFlightPage(reports);
		commonPageMethod = new CommonPageMethodUtil();
		cancelTrip = new CancelTripPage(reports);
	}

	@BeforeMethod
	public void setupReport(Method m) throws Exception {
		reports.startTest(m.getName(), "ArchanaD", "Manage My Booking");
		homePage.clickOnSaudiaLogo();
	}

	@Test(priority = 1, description = "Rebooking - Change flight DATE in MMB page for OW", enabled = false)
	public void changeFlihgtDate() {
		try {
			/*
			 * preReq.oneWayFlightBooking(homePage, passengerdetailspage, paymentpages,
			 * flightPage, depFlightClass, seatAndExtras, depSubFareCard);
			 * 
			 * homePage.clickOnSaudiaLogo();
			 */

			homePage.searchPNRinMMBTab(CommonMethodUtil.bookingReferenceOW, GetTestData.lastName);
			preReq.changeFlight(1, mmb, changeFlight, LayoutHeader.ChangeFlightDate);

			Log.info("Retrive PNR in MMB");

		} catch (Throwable e) {
			reports.logFail("Error while Change flight date in MMB page for OW: ", e);
			Log.error("Error while Change flight date in MMB page for OW ", e);
		}
	}

	@Test(priority = 2, description = "Rebooking - Change flight ROUTE in MMB page for OW", enabled = false)
	public void changeFlightRoute() {
		try {
			
			homePage.searchPNRinMMBTab(CommonMethodUtil.bookingReferenceOW, GetTestData.lastName);
			preReq.changeFlight(1, mmb, changeFlight, LayoutHeader.ChangeFlightRoute);
			Log.info("Change flight route in MMB page");

		} catch (Throwable e) {
			reports.logFail("Error in Change flight route in MMB page for OW: ", e);
			Log.error("Error in Change flight route in MMB page  for OW ", e);
		}
	}
	
	@Test(priority = 3, description = "Rebooking - Change flight DATE in MMB page for RT", enabled = false)
	public void changeFlihgtDateRT() {
		try {
			/*
			 * preReq.oneWayFlightBooking(homePage, passengerdetailspage, paymentpages,
			 * flightPage, depFlightClass, seatAndExtras, depSubFareCard);
			 * 
			 * homePage.clickOnSaudiaLogo();
			 */

			homePage.searchPNRinMMBTab(CommonMethodUtil.bookingReferenceRT, GetTestData.lastName);
			preReq.changeFlight(2, mmb, changeFlight, LayoutHeader.ChangeFlightDate);

			Log.info("Retrive PNR in MMB");

		} catch (Throwable e) {
			reports.logFail("Error while Change flight date in MMB page for OW: ", e);
			Log.error("Error while Change flight date in MMB page for OW ", e);
		}
	}

	@Test(priority = 4, description = "Rebooking - Change flight ROUTE in MMB page for RT", enabled = false)
	public void changeFlightRouteRT() {
		try {
			
			homePage.searchPNRinMMBTab(CommonMethodUtil.bookingReferenceRT, GetTestData.lastName);
			preReq.changeFlight(2, mmb, changeFlight, LayoutHeader.ChangeFlightRoute);
			Log.info("Change flight route in MMB page");

		} catch (Throwable e) {
			reports.logFail("Error in Change flight route in MMB page for OW: ", e);
			Log.error("Error in Change flight route in MMB page  for OW ", e);
		}
	}
	
	@AfterMethod
	public void tearDown() {
		reports.endTest();
	}

}
