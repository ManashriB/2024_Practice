package com.saudia.qa.FunctionalTestcase;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saudia.qa.base.TestBase;
import com.saudia.qa.pages.AltanfeethiVIPServicePage;
import com.saudia.qa.pages.EvisaPage;
import com.saudia.qa.pages.ExtraBaggagePage;
import com.saudia.qa.pages.FastTrackPage;
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

public class PaymentsTest extends TestBase {

	HomePage homePage;
	PassengerDetailsPage passengerdetailspage;
	PaymentPage paymentpages;
	PreReqUtil preReq;
	FlightPage flightPage;
	SeatsAndExtras seatAndExtras;
	FastTrackPage fastTrack;
	EvisaPage eVisa;
	SeatSelectionPage seatSelection;
	ExtraBaggagePage extraBaggage;
	AltanfeethiVIPServicePage altanfeethiVIPService;
	List<String> ancillary ;

	@BeforeClass
	public void setup() throws Throwable {
		homePage = new HomePage(reports);
		passengerdetailspage = new PassengerDetailsPage(reports);
		paymentpages = new PaymentPage(reports);
		// homePage.acceptPrivacyCookies();
		// homePage.changeCountryIndiaToSaudiArabia(GetTestData.searchCountryText);
		preReq = new PreReqUtil();
		flightPage = new FlightPage(reports);
		seatAndExtras = new SeatsAndExtras(reports);
		eVisa = new EvisaPage(reports);
		seatSelection = new SeatSelectionPage(reports);
		extraBaggage = new ExtraBaggagePage(reports);
		altanfeethiVIPService = new AltanfeethiVIPServicePage(reports);
		fastTrack = new FastTrackPage(reports);
		ancillary = new ArrayList<String>(Arrays.asList(GetTestData.Select_Ancillaries.split(", ")));
	}

	@BeforeMethod
	public void setupReport(Method m) throws Exception {
		reports.startTest(m.getName(), "ArchanaD", "Payments Page");
		homePage.clickOnSaudiaLogo();
	}

	@Test(priority = 1, description = "Verify Anscillaries added in Payments page One way", enabled = false)
	public void verifySeatsAndExtrasSectionInPaymentPageOW() {

		try {
			String depFlightClass = GetTestData.Departure_Flight_Class_OW;
			String depSubFareCard = GetTestData.Departure_Flight_SubClass_OW;

			preReq.oneWayFlightBookingTillSeatsAndExtrasPage(homePage, passengerdetailspage, paymentpages, flightPage,
					depFlightClass, seatAndExtras, depSubFareCard);

			double fareAmountUI = seatAndExtras.getTotalFareAmount();
			ArrayList<String[]> returnData = preReq.selectAncillaries(ancillary, 1, seatAndExtras, fastTrack,
					seatSelection, extraBaggage, altanfeethiVIPService);
			double ancillaryAmount = 0.00d;
			Integer count[] = new Integer[4];

			int k = 0;
			for (String[] array : returnData) {
				ancillaryAmount = ancillaryAmount + Double.parseDouble(array[0]);
				count[k] = Integer.parseInt(array[1]);
				k++;
			}

			seatAndExtras.proceedToPayment();
			paymentpages.verifyAncillariesInSection(ancillary, count);
			paymentpages.verifyTotalFare(fareAmountUI, ancillaryAmount);

			Log.info("Verify Seats and Extras section in Payments Page is Successfull for OW");

		} catch (Throwable e) {
			reports.logFail("Verification of Seats and Extras section in Payments Page is Failed for OW: ", e);
			Log.error("Verification of Seats and Extras section in Payments Page is Failed for OW ", e);
		}
	}

	@Test(priority = 2, description = "Verify Anscillaries added in Payments page for Round Trip", enabled = false)
	public void verifySeatsAndExtrasSectionPaymentPageRT() {

		try {
			String depFlightClass = GetTestData.Departure_Flight_Class_RT;
			String depSubFareCard = GetTestData.Departure_Flight_SubClass_RT;
			String retFlightClass = GetTestData.Return_Flight_Class_RT;
			String retSubFareCard = GetTestData.Return_Flight_SubClass_RT;

			preReq.roundWayFlightBookingTillSeatsAndExtrasPage(homePage, passengerdetailspage, paymentpages, flightPage,
					depFlightClass, seatAndExtras, depSubFareCard, retFlightClass, retSubFareCard);

			double fareAmountUI = seatAndExtras.getTotalFareAmount();
			System.out.println("fare = " + fareAmountUI);
			ArrayList<String[]> returnData = preReq.selectAncillaries(ancillary, 2, seatAndExtras, fastTrack,
					seatSelection, extraBaggage, altanfeethiVIPService);

			double ancillaryAmount = 0.00d;
			Integer count[] = new Integer[4];

			int k = 0;
			for (String[] array : returnData) {
				ancillaryAmount = ancillaryAmount + Double.parseDouble(array[0]);
				count[k] = Integer.parseInt(array[1]);
				k++;
			}

			seatAndExtras.proceedToPayment();
			paymentpages.verifyAncillariesInSection(ancillary, count);
			paymentpages.verifyTotalFare(fareAmountUI, ancillaryAmount);

			Log.info("Verify Seats and Extras section in Payments Page is Successfull for RT");

		} catch (Throwable e) {
			reports.logFail("Verification of Seats and Extras section in Payments Page is Failed for RT: ", e);
			Log.error("Verification of Seats and Extras section in Payments Page is Failed for RT", e);
		}
	}

	@Test(priority = 3, description = "Verify Anscillaries added in Payments page for Multicity", enabled = true)
	public void verifySeatsAndExtrasSectionPaymentPageMC() {
		try {

			int noOfBounds = 3;
			String cardNumber = null, cardExpiry = null, cardCVV = null;
			
			preReq.multiCityFlightBookingTillSeatsandExtras(homePage, passengerdetailspage, paymentpages, flightPage,
					seatAndExtras, noOfBounds);

			double fareAmountUI = seatAndExtras.getTotalFareAmount();
			ArrayList<String[]> returnData = preReq.selectAncillaries(ancillary, noOfBounds, seatAndExtras, fastTrack, seatSelection,
					extraBaggage, altanfeethiVIPService);

			double ancillaryAmount = 0.00d;
			Integer count[] = new Integer[4];
			
			int k = 0;
			for (String[] array : returnData) {
			        ancillaryAmount = ancillaryAmount + Double.parseDouble(array[0]);
			        count[k] = Integer.parseInt(array[1]);		
			        k++;
			}
			
			seatAndExtras.proceedToPayment();
			paymentpages.verifyAncillariesInSection(ancillary, count);
			//paymentpages.verifyTotalFare(fareAmountUI, ancillaryAmount);
			paymentpages.verifyPassengersSection(GetTestData.countryCode, GetTestData.phoneNumber, GetTestData.email, GetTestData.title ,GetTestData.firstName, GetTestData.lastName);
			paymentpages.verifyPaymentMethodSection(fareAmountUI, 0.00);
			paymentpages.bookingPayment(GetTestData.CardHolder_Name,GetTestData.PaymentMode);
			paymentpages.verifyPaymentIsCompleted();
			paymentpages.saveBookingReferences(noOfBounds);

			Log.info("Verify Seats and Extras section in Payments Page is Successfull for MC");

		} catch (Throwable e) {
			reports.logFail("Verification of Seats and Extras section in Payments Page is Failed for MC", e);
			Log.error("Verification of Seats and Extras section in Payments Page is Failed for MC", e);
		}
	}

	@Test(priority = 4, description = "Verify Header, Passenger Section, Payment Method Section in Payments page One way", enabled = false)
	public void verifySectionsInPaymentPageOW() {

		try {
			String depFlightClass = GetTestData.Departure_Flight_Class_OW;
			String depSubFareCard = GetTestData.Departure_Flight_SubClass_OW;

			preReq.oneWayFlightBooking(homePage, passengerdetailspage, paymentpages, flightPage, depFlightClass,
					seatAndExtras, depSubFareCard);

			Log.info("Verify Header, Passenger Section, Payment Method Section in Payments page One way");

		} catch (Throwable e) {
			reports.logFail("Verification of Header, Passenger Section, Payment Method Section in payment page is Failed for OW : ", e);
			Log.error("Verification of Header, Passenger Section, Payment Method Section in payment page is Failed for OW : ", e);
		}
	}
	
	@Test(priority = 5, description = "Verify Header, Passenger Section, Payment Method in Payments page Round Trip", enabled = false)
	public void verifySectionsInPaymentPageRT() {

		try {
			String depFlightClass = GetTestData.Departure_Flight_Class_RT;
			String depSubFareCard = GetTestData.Departure_Flight_SubClass_RT;
			String retFlightClass = GetTestData.Return_Flight_Class_RT;
			String retSubFareCard = GetTestData.Return_Flight_SubClass_RT;

			preReq.roundWayFlightBooking(homePage, passengerdetailspage, paymentpages, flightPage,
					depFlightClass, seatAndExtras, depSubFareCard, retFlightClass, retSubFareCard);

			Log.info("Verify Header, Passenger Section, Payment Method in Payments page One way is Successfull for RT");

		} catch (Throwable e) {
			reports.logFail("Verification of Header, Passenger Section, Payment Method in Payments page is Failed for RT: ", e);
			Log.error("Verification of Header, Passenger Section, Payment Method in Payments page is Failed for RT", e);
		}
	}
	
	@Test(priority = 6, description = "Verify Header, Passenger Section, Payment Method in Payments page Multicity", enabled = false)
	public void verifySectionsInPaymentPageMC() {

		try {

			int noOfBounds = 3;
			preReq.multiCityFlightBooking(homePage, passengerdetailspage, paymentpages, flightPage,
					seatAndExtras, noOfBounds);
			
			Log.info("Verify Header, Passenger Section, Payment Method in Payments page is Successfull for MC");

		} catch (Throwable e) {
			reports.logFail("Verification of Header, Passenger Section, Payment Method in Payments page is Failed for MC : ", e);
			Log.error("Verification of Header, Passenger Section, Payment Method in Payments page is Failed for MC :", e);
		}
	}

	@AfterMethod
	public void tearDown() {
		reports.endTest();
	}
}
