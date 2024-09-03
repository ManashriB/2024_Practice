package com.saudia.qa.util;

import java.util.ArrayList;
import java.util.List;

import com.saudia.qa.config.Constants;
import com.saudia.qa.pages.AltanfeethiVIPServicePage;
import com.saudia.qa.pages.ChangeFlightPage;
import com.saudia.qa.pages.CheckInPage;
import com.saudia.qa.pages.EvisaPage;
import com.saudia.qa.pages.ExtraBaggagePage;
import com.saudia.qa.pages.FastTrackPage;
import com.saudia.qa.pages.FlightPage;
import com.saudia.qa.pages.HomePage;
import com.saudia.qa.pages.MMBPage;
import com.saudia.qa.pages.PassengerDetailsPage;
import com.saudia.qa.pages.PaymentPage;
import com.saudia.qa.pages.SeatSelectionPage;
import com.saudia.qa.pages.SeatsAndExtras;

public class PreReqUtil {
	
	double totalFareCardAmountMC = 0.0d;
	
	// Complete One Way Flight Booking including Payment
	public void oneWayFlightBooking(HomePage homePage, PassengerDetailsPage passengerdetailspage,
			PaymentPage paymentpages, FlightPage flightPage, String depFlightClass, SeatsAndExtras seatAndExtras,
			String depSubFareCard) throws Throwable {
		homePage.oneWayTripMethod(GetTestData.origin1, GetTestData.destination1);
		homePage.datepickerCalOW(GetTestData.departingMonth, GetTestData.departingDate);
		// homePage.addPassenger();
		homePage.clickSearchFlightsBTN();
		homePage.dontChangeBTNMethod();
		flightPage.verifyFlightDetailsPageIsOpened();
		flightPage.selectFareCardOW(depFlightClass, depSubFareCard);
		flightPage.verifyFlightRoute(1, GetTestData.origin1, GetTestData.destination1);
		flightPage.verifyFlightDates(1, GetTestData.departingDate, GetTestData.departingMonth.split(" ")[0], GetTestData.returnDate,
				GetTestData.retunMonth.split(" ")[0]);
		double totalFareCardAmount  = flightPage.verifySelectedFareCardAmount();	
		homePage.clickContToPassenger();
		passengerdetailspage.addPassengerDetails(GetTestData.title, GetTestData.firstName, GetTestData.lastName,
				GetTestData.birthdayDate, GetTestData.nationality, GetTestData.passportNumber,
				GetTestData.passportExpiryDate, GetTestData.passportIssuingCountry);
		passengerdetailspage.addContactDetails(GetTestData.countryCode, GetTestData.phoneNumber, GetTestData.email);
		seatAndExtras.skipToPayment();  
		paymentpages.verifyHeader(1, GetTestData.origin1, GetTestData.destination1, GetTestData.departingDate,
				GetTestData.departingMonth.split(" ")[0], GetTestData.returnDate, GetTestData.retunMonth.split(" ")[0]);
		paymentpages.verifyPassengersSection(GetTestData.countryCode, GetTestData.phoneNumber, GetTestData.email, GetTestData.title ,GetTestData.firstName, GetTestData.lastName);
		paymentpages.verifyPaymentMethodSection(totalFareCardAmount, 0.00);
		paymentpages.bookingPayment(GetTestData.CardHolder_Name, GetTestData.PaymentMode);
		paymentpages.verifyPaymentIsCompleted();
		paymentpages.saveBookingReferences(1);
	}

	// Complete Round trip Flight Booking including Payment
	public void roundWayFlightBooking(HomePage homePage, PassengerDetailsPage passengerdetailspage,
			PaymentPage paymentpages, FlightPage flightPage, String depFlightClass, SeatsAndExtras seatAndExtras,
			String depSubFareCard, String retFareCrad, String retSubFareCard) throws Throwable {

		homePage.roundTripMethod(GetTestData.origin1, GetTestData.destination1);
		homePage.datePickerRT(GetTestData.departingMonth, GetTestData.departingDate, GetTestData.retunMonth,
				GetTestData.returnDate);
		// homePage.addPassenger();
		homePage.clickSearchFlightsBTN();
		homePage.dontChangeBTNMethod();
		flightPage.verifyFlightDetailsPageIsOpened();
		flightPage.selectFareCardRT(depFlightClass, depSubFareCard, retFareCrad, retSubFareCard);
		flightPage.verifyFlightRoute(2, GetTestData.origin1, GetTestData.destination1);
		flightPage.verifyFlightDates(2, GetTestData.departingDate, GetTestData.departingMonth.split(" ")[0], GetTestData.returnDate,
				GetTestData.retunMonth.split(" ")[0]);
		double totalFareCardAmount  = flightPage.verifySelectedFareCardAmount();

		homePage.clickContToPassenger();
		passengerdetailspage.verifyPassengerDetailsPageIsOpened();
		passengerdetailspage.addPassengerDetails(GetTestData.title, GetTestData.firstName, GetTestData.lastName,
				GetTestData.birthdayDate, GetTestData.nationality, GetTestData.passportNumber,
				GetTestData.passportExpiryDate, GetTestData.passportIssuingCountry);
		passengerdetailspage.addContactDetails(GetTestData.countryCode, GetTestData.phoneNumber, GetTestData.email);
		seatAndExtras.skipToPayment();	
		paymentpages.verifyPaymentPageIsOpened();
		paymentpages.verifyHeader(2, GetTestData.origin1, GetTestData.destination1, GetTestData.departingDate,
				GetTestData.departingMonth.split(" ")[0], GetTestData.returnDate, GetTestData.retunMonth.split(" ")[0]);
		paymentpages.verifyPassengersSection(GetTestData.countryCode, GetTestData.phoneNumber, GetTestData.email,
				GetTestData.title, GetTestData.firstName, GetTestData.lastName);
		paymentpages.verifyPaymentMethodSection(totalFareCardAmount, 0.00);
		paymentpages.bookingPayment(GetTestData.CardHolder_Name,GetTestData.PaymentMode);
		paymentpages.verifyPaymentIsCompleted();
		paymentpages.saveBookingReferences(2);
	}

	// Complete Multicity flight Booking including Payment
	public void multiCityFlightBooking(HomePage homePage, PassengerDetailsPage passengerdetailspage,
			PaymentPage paymentpages, FlightPage flightPage, SeatsAndExtras seatAndExtras, int noOfBounds)
			throws Throwable {

		System.out.println("noOfBounds = " + noOfBounds);
		String routeTestData = getRoutesTestData(noOfBounds);
		String[] route = routeTestData.split("-", 0);

		if (noOfBounds >= 2 && noOfBounds <= 6) {

			bookFlightMC(homePage, passengerdetailspage, flightPage, seatAndExtras, noOfBounds, route);
			seatAndExtras.skipToPayment();
			paymentpages.verifyPaymentPageIsOpened();
			paymentpages.verifyHeaderMC(noOfBounds);
			paymentpages.verifyPassengersSection(GetTestData.countryCode, GetTestData.phoneNumber, GetTestData.email,
					GetTestData.title, GetTestData.firstName, GetTestData.lastName);
			paymentpages.verifyPaymentMethodSection(totalFareCardAmountMC, 0.00);
			paymentpages.bookingPayment(GetTestData.CardHolder_Name,GetTestData.PaymentMode);
			paymentpages.verifyPaymentIsCompleted();
			paymentpages.saveBookingReferences(noOfBounds);
		} else {
			throw new Exception(
					"Minimum 2 bounds and maximum 6 bounds are allowed in Multicity flight booking. Please check route in testdata");
		}
	}

	// Common method for multicity flight booking
	private void bookFlightMC(HomePage homePage, PassengerDetailsPage passengerdetailspage, FlightPage flightPage,
			SeatsAndExtras seatAndExtras, int noOfBounds, String[] route) throws Throwable {

		// For bounds > 2
		String flightClass = GetTestData.Flight_Class_MC;
		String flightSubClass = GetTestData.Flight_SubClass_MC;
		// For bound = 2
		String depFlightClass = GetTestData.Departure_Flight_Class_Bound2_MC;
		String depSubFareClass = GetTestData.Departure_Flight_SubClass_Bound2_MC;
		String retFlightClass = GetTestData.Return_Flight_Class_Bound2_MC;
		String retSubFareClass = GetTestData.Return_Flight_SubClass_Bound2_MC;

		homePage.multiCityMethod(route, GetTestData.departingMonthDataMC, GetTestData.departingDateDataMC);
		homePage.expandPassengerandClassDropdown();

		if (noOfBounds == 2) {
			// homePage.selectFareCardClass(depFlightClass);
			homePage.clickSearchFlightsBTN();
			homePage.dontChangeBTNMethod();
			flightPage.verifyFlightDetailsPageIsOpened();
			flightPage.selectFareCardRT(depFlightClass, depSubFareClass, retFlightClass, retSubFareClass);
			flightPage.verifyFlightRoute(2, route[0], route[1]);
			flightPage.verifyFlightDates(2, GetTestData.departingDateDataMC.get(0),
					GetTestData.departingMonthDataMC.get(0), GetTestData.departingDateDataMC.get(1),
					GetTestData.departingMonthDataMC.get(1));
			totalFareCardAmountMC = flightPage.verifySelectedFareCardAmount();
			homePage.clickContToPassenger();	
			
		} else {
			homePage.selectFareCardClass(flightClass);
			homePage.clickSearchFlightsBTN();
			homePage.dontChangeBTNMethod();

			flightPage.verifyFlightDetailsPageIsOpened();
			flightPage.verifyTourGuideBlockForPreferredFlightsMC();
			flightPage.verifyFlightsAvailability();
			flightPage.verifyClassForFirstBundleInMC(flightClass);
			flightPage.verifyFlightRouteAndDateMC(noOfBounds, route, GetTestData.departingMonthDataMC,
					GetTestData.departingDateDataMC);
			String seatFare = flightPage.selectSubFareCardMC(flightClass, flightSubClass);
			String fareAmount = flightPage.handleTotalFarePopupMC();
			flightPage.verifySelectedFareCardAmountMC(seatFare, fareAmount);
		}
		passengerdetailspage.verifyPassengerDetailsPageIsOpened();
		passengerdetailspage.addPassengerDetails(GetTestData.title, GetTestData.firstName, GetTestData.lastName,
				GetTestData.birthdayDate, GetTestData.nationality, GetTestData.passportNumber,
				GetTestData.passportExpiryDate, GetTestData.passportIssuingCountry);
		passengerdetailspage.addContactDetails(GetTestData.countryCode, GetTestData.phoneNumber, GetTestData.email);
		seatAndExtras.verifySeatAndExtrasPageIsOpened();
	}

	// To get route test data for 2,3,4,5,6 bounds for multicity
	private String getRoutesTestData(int noOfBounds) throws Exception {
		String routeTestData = null;
		if (noOfBounds == 2) {
			routeTestData = GetTestData.Route_Bound2_MC;
		} else if (noOfBounds == 3) {
			routeTestData = GetTestData.Route_Bound3_MC;
		} else if (noOfBounds == 4) {
			routeTestData = GetTestData.Route_Bound4_MC;
		} else if (noOfBounds == 5) {
			routeTestData = GetTestData.Route_Bound5_MC;
		} else if (noOfBounds == 6) {
			routeTestData = GetTestData.Route_Bound6_MC;
		} else {
			throw new Exception("Invalid number of bounds. Please check route in testdata");
		}
		return routeTestData;
	}

	// One Way Flight Booking Till SeatsAndExtrasPage
	public void oneWayFlightBookingTillSeatsAndExtrasPage(HomePage homePage, PassengerDetailsPage passengerdetailspage,
			PaymentPage paymentpages, FlightPage flightPage, String depFlightClass, SeatsAndExtras seatAndExtras,
			String depSubFareCard) throws Throwable {

		homePage.oneWayTripMethod(GetTestData.origin1, GetTestData.destination1);
		homePage.datepickerCalOW(GetTestData.departingMonth, GetTestData.departingDate);
		// homePage.addPassenger();
		homePage.clickSearchFlightsBTN();
		homePage.dontChangeBTNMethod();
		flightPage.verifyFlightDetailsPageIsOpened();
		flightPage.selectFareCardOW(depFlightClass, depSubFareCard);
		flightPage.verifySelectedFareCardAmount();
		homePage.clickContToPassenger();
		passengerdetailspage.addPassengerDetails(GetTestData.title, GetTestData.firstName, GetTestData.lastName,
				GetTestData.birthdayDate, GetTestData.nationality, GetTestData.passportNumber,
				GetTestData.passportExpiryDate, GetTestData.passportIssuingCountry);
		passengerdetailspage.addContactDetails(GetTestData.countryCode, GetTestData.phoneNumber, GetTestData.email);
	}

	// Round Trip Flight Booking Till SeatsAndExtrasPage
	public void roundWayFlightBookingTillSeatsAndExtrasPage(HomePage homePage,
			PassengerDetailsPage passengerdetailspage, PaymentPage paymentpages, FlightPage flightPage,
			String depFlightClass, SeatsAndExtras seatAndExtras, String depSubFareCard, String retFareCrad,
			String retSubFareCard) throws Throwable {

		homePage.roundTripMethod(GetTestData.origin1, GetTestData.destination1);
		homePage.datePickerRT(GetTestData.departingMonth, GetTestData.departingDate, GetTestData.retunMonth,
				GetTestData.returnDate);
		// homePage.addPassenger();
		homePage.clickSearchFlightsBTN();
		homePage.dontChangeBTNMethod();
		flightPage.selectFareCardRT(depFlightClass, depSubFareCard, retFareCrad, retSubFareCard);
		flightPage.verifySelectedFareCardAmount();
		homePage.clickContToPassenger();
		passengerdetailspage.verifyPassengerDetailsPageIsOpened();
		passengerdetailspage.addPassengerDetails(GetTestData.title, GetTestData.firstName, GetTestData.lastName,
				GetTestData.birthdayDate, GetTestData.nationality, GetTestData.passportNumber,
				GetTestData.passportExpiryDate, GetTestData.passportIssuingCountry);
		passengerdetailspage.addContactDetails(GetTestData.countryCode, GetTestData.phoneNumber, GetTestData.email);

	}

	// Multicity flight Booking till 'Seats and Extras' Page
	public void multiCityFlightBookingTillSeatsandExtras(HomePage homePage, PassengerDetailsPage passengerdetailspage,
			PaymentPage paymentpages, FlightPage flightPage, SeatsAndExtras seatAndExtras, int noOfBounds)
			throws Throwable {

		String[] route = getRoutesTestData(noOfBounds).split("-", 0);

		if (noOfBounds >= 2 && noOfBounds <= 6) {
			bookFlightMC(homePage, passengerdetailspage, flightPage, seatAndExtras, noOfBounds, route);

		} else {
			throw new Exception(
					"Minimum 2 bounds and maximum 6 bounds are allowed in Multicity flight booking. Please check route in testdata");
		}

	}

	// Add Extra baggage for Passenger in 'Seat and Extras' Page
	public String[] addExtraBaggage(int noOfBounds, SeatsAndExtras seatAndExtras, ExtraBaggagePage extraBaggage)
			throws Exception {
		
		String[] returnData = new String[2];
		String addedBagsData = null;
		int totalBags = 0;
		String totalAmount = null;

		seatAndExtras.clickOnAddExtraBaggageBTN();

		for (int i = 1; i <= noOfBounds; i++) {
			if (i == 1) {
				System.out.println("Add Extra Baggage for Departing Flight");
				addedBagsData = extraBaggage.addExtraBaggageDeparting(
						Integer.parseInt(GetTestData.ExtraBags_MAX_Allowed_Count), GetTestData.ExtraBaggage_Amount_DOM,
						GetTestData.ExtraBags_Allowed_Weight);
			} else {
				System.out.println("Add Extra Baggage for Return Flight");
				addedBagsData = extraBaggage.addExtraBaggageReturning(
						Integer.parseInt(GetTestData.ExtraBags_MAX_Allowed_Count), GetTestData.ExtraBaggage_Amount_DOM,
						GetTestData.ExtraBags_Allowed_Weight, totalAmount, i);
			}

			if (i == noOfBounds) {
				extraBaggage.clickConfirmBTN();
			} else {
				extraBaggage.clickNextFlightBTN();
			}

			totalBags = totalBags + Integer.parseInt(addedBagsData.split(":")[0]);
			totalAmount = addedBagsData.split(":")[1].replaceAll(",", "");
		}

		//String returnData = totalBags + ":SAR " + String.format("%,.2f", Double.parseDouble(totalAmount.split(" ")[1]));
		System.out.println("Add Extra baggage return data = " + returnData);
		
		returnData[0] = String.valueOf(totalBags);
		returnData[1] = String.valueOf(String.format("%,.2f", Double.parseDouble(totalAmount.split(" ")[1])));
		return returnData;
		//return returnData;
	}

	// Modify Extra baggage for Passenger in 'Seat and Extras' Page
	public String modifyExtraBaggage(int noOfBounds, SeatsAndExtras seatAndExtras, ExtraBaggagePage extraBaggage)
			throws Exception {
		String modifiedBagsData = null;
		int totalBags = 0;
		String totalAmount = null;
		double remainingAmount;

		double totalModiffyAmount = seatAndExtras.clickOnModifyExtraBaggageLink();
		int noOfBagsRemove = Integer.parseInt(GetTestData.ExtraBags_MAX_Allowed_Count);

		for (int i = 1; i <= noOfBounds; i++) {
			if (i == 1) {
				System.out.println("Modify Extra Baggage for Departing Flight");
				modifiedBagsData = extraBaggage.modifyExtraBagsAddedDeparting(
						Integer.parseInt(GetTestData.ExtraBags_MAX_Allowed_Count), GetTestData.ExtraBaggage_Amount_DOM,
						noOfBagsRemove, GetTestData.ExtraBags_Allowed_Weight, totalModiffyAmount);
			} else {
				System.out.println("Modify Extra Baggage for Return Flight");
				remainingAmount = Double.parseDouble(totalAmount.split(" ")[1].replaceAll(",", ""));
				modifiedBagsData = extraBaggage.modifyExtraBagsAddedReturning(
						Integer.parseInt(GetTestData.ExtraBags_MAX_Allowed_Count), GetTestData.ExtraBaggage_Amount_DOM,
						noOfBagsRemove, GetTestData.ExtraBags_Allowed_Weight, remainingAmount, i);
			}

			if (i == noOfBounds) {
				extraBaggage.clickConfirmBTN();
			} else {
				extraBaggage.clickNextFlightBTN();
			}

			totalBags = totalBags + Integer.parseInt(modifiedBagsData.split(":")[0]);
			totalAmount = modifiedBagsData.split(":")[1].replaceAll(",", "");
		}

		String returnData = totalBags + ":SAR " + String.format("%,.2f", Double.parseDouble(totalAmount.split(" ")[1]));
		System.out.println("Modify Extra baggage return data = " + returnData);
		return returnData;
	}

	// Add Fast Track for Passenger in 'Seat and Extras' Page
	public String[] addFastTrack(int noOfBounds, SeatsAndExtras seatAndExtras, FastTrackPage fastTrack) throws Exception {

		String[] returnData = new String[2];
		int subTotalAmount = 0;
		int availableFTrackFlightCount = 0;
		seatAndExtras.checkFastTrackOptionIsPresent();
		seatAndExtras.clickOnAddFastTrackBTN();
		fastTrack.verifyFastTrackPageIsOpened();

		for (int i = 1; i <= noOfBounds; i++) {

			boolean available = fastTrack.checkFastTrackAvailableForFlight(i);
			if (available) {
				subTotalAmount = fastTrack.addFastTrackAllFlights(subTotalAmount, GetTestData.FastTrack_Amount_DOM, i,
						noOfBounds);
				availableFTrackFlightCount++;
			}
			if (i == noOfBounds) {
				fastTrack.clickConfirmBTN();
			} else {
				fastTrack.clickNextFlightBTN();
			}
		}
		System.out.println("Total Fast track return data = " + subTotalAmount);
		
		returnData[0] = String.valueOf(subTotalAmount);
		returnData[1] = String.valueOf(availableFTrackFlightCount);
		return returnData;
		//return subTotalAmount + "@" + availableFTrackFlightCount;
	}

	// Modify Fast Track for Passenger in 'Seat and Extras' Page
	public void modifyFastTrack(int noOfBounds, SeatsAndExtras seatAndExtras, FastTrackPage fastTrack)
			throws Exception {

		seatAndExtras.checkFastTrackOptionIsPresent();
		seatAndExtras.clickOnModifyFastTrackBTN();
		fastTrack.verifyFastTrackPageIsOpened();

		for (int i = 1; i <= noOfBounds; i++) {

			boolean available = fastTrack.checkFastTrackAvailableForFlight(i);
			if (available) {
				fastTrack.modifyFastTrackAllFlights(i);
			}
			if (i == noOfBounds) {
				fastTrack.clickConfirmBTN();
			} else {
				fastTrack.clickNextFlightBTN();
			}
		}
	}

	// Add Altanfeethi VIP Service in 'Seat and Extras' Page
	public String[] addALTVIPService(int noOfBounds, SeatsAndExtras seatAndExtras,
			AltanfeethiVIPServicePage altanfeethiVIPService) throws Throwable {
		try {
			String[] returnData = new String[2];
			double subTotalAmount = 0;
			int availableALTFlightCount = 0;
			seatAndExtras.checkAltanfeethiVIPServiceOptionIsPresent();
			seatAndExtras.clickOnAddALTANFEETHIBTN();
			altanfeethiVIPService.verifyALTVIPServicePageIsOpened();

			for (int i = 1; i <= noOfBounds; i++) {
				boolean available = altanfeethiVIPService.checkAltanfeethiAvailableForFlight(i);
				if (available) {
					subTotalAmount = altanfeethiVIPService.addAltanfeethiAllFlights(subTotalAmount,
							GetTestData.Altanfeethi_Amount_DOM, GetTestData.Altanfeethi_VIP_Service_Name, i);
					availableALTFlightCount++;
				}
				if (i == noOfBounds) {
					altanfeethiVIPService.clickConfirmBTN();
				} else {
					altanfeethiVIPService.clickNextFlightBTN();
				}
			}
			System.out.println("Total Altanfeethi VIP Service return data = " + subTotalAmount);
			returnData[0] = String.valueOf(subTotalAmount);
			returnData[1] = String.valueOf(availableALTFlightCount);
			return returnData;
			//return subTotalAmount + "@" + availableALTFlightCount;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While adding Altanfeethi VIP Service");
		}
	}

	// Modify Altanfeethi for Passenger in 'Seat and Extras' Page
	public void modifyALTVIPService(int noOfBounds, SeatsAndExtras seatAndExtras,
			AltanfeethiVIPServicePage altanfeethiVIPService) throws Exception {

		try {
			seatAndExtras.checkAltanfeethiVIPServiceOptionIsPresent();
			seatAndExtras.clickModifyALTANFEETHILink();
			altanfeethiVIPService.verifyALTVIPServicePageIsOpened();

			double totalAmount = Double.parseDouble(GetTestData.Altanfeethi_Amount_DOM.split(" ")[1]);

			for (int i = 1; i <= noOfBounds; i++) {
				boolean available = altanfeethiVIPService.checkAltanfeethiAvailableForFlight(i);
				if (available) {

					altanfeethiVIPService.modifyAltanfeethiAllFlights("SAR " + totalAmount,
							GetTestData.Altanfeethi_Amount_DOM, GetTestData.Altanfeethi_VIP_Service_Name, i);
				}
				if (i == noOfBounds) {
					altanfeethiVIPService.clickConfirmBTN();
				} else {
					altanfeethiVIPService.clickNextFlightBTN();
				}

			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new Exception("Error While modifing Altanfeethi VIP Service");
		}

	}

	// Seat Selected Service in 'Seat and Extras' Page
	public String[] SeatSelection(int noOfBounds, SeatsAndExtras seatAndExtras, SeatSelectionPage seatSelection)
			throws Throwable {
		try {
			double subTotalAmount = 0;
			int availableSeatCount = 0;
			String[] returnData = new String[2];
			seatAndExtras.checkSeatSelectionOptionIsPresent();
			seatAndExtras.clickOnSelectSeatBTN();
			seatSelection.verifySeatSelectionPageIsOpened();
			for (int i = 1; i <= noOfBounds; i++) {
				Thread.sleep(1000);
				boolean available = seatSelection.checkSeatAvailableForFlight(i);

				if (available) {
					subTotalAmount = seatSelection.seatSelectionAllFlights(subTotalAmount, i);                     //need to remove all seat amount from test data take from UI
					availableSeatCount++;
				}
				if (i == noOfBounds) {
					seatSelection.clickConfirmBTN();
				} else {
					// seatSelection.clickNextFlightBTN();
				}
			}
			returnData[0] = String.valueOf(subTotalAmount);
			returnData[1] = String.valueOf(availableSeatCount);
			return returnData;

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error While Selecting Seat Service");
		}
	}

	public void modifySelectedSeatService(int noOfBounds, SeatsAndExtras seatAndExtras, SeatSelectionPage seatSelection)
			throws Exception {
		try {
			seatAndExtras.clickModifySeatSelecetedLink();
			seatSelection.verifySeatSelectionPageIsOpened();
			String paxDetails = GetTestData.firstName + " " + GetTestData.lastName;
			for (int i = 1; i <= noOfBounds; i++) {
				boolean available = seatSelection.checkSeatAvailableForFlight(i);
				if (available) {
					seatSelection.modifySeatSelectedAllFlights(paxDetails);
				}
				if (i == noOfBounds) {
					// seatSelection.clickConfirmBTN();
				} else {
					seatSelection.clickConfirmBTN();
					// seatSelection.clickNextFlightBTN();
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new Exception("Error While modifing Selected seat Service");
		}
	}
	
	// One way Flight booking for E-Visa
	public void applyForEvisa(HomePage homePage, PassengerDetailsPage passengerdetailspage, PaymentPage paymentpages,
			FlightPage flightPage, String depFlightClass, SeatsAndExtras seatAndExtras, String depSubFareCard,
			EvisaPage eVisa) throws Throwable {

		homePage.oneWayTripMethod(GetTestData.Origin_INTL, GetTestData.Destination_INTL);
		homePage.datepickerCalOW(GetTestData.departingMonth, GetTestData.departingDate);
		homePage.clickSearchFlightsBTN();
		homePage.dontChangeBTNMethod();
		flightPage.verifyFlightDetailsPageIsOpened();
		//flightPage.visitSaudiEVisa();

		Thread.sleep(5000);
		flightPage.selectFareCardOW(depFlightClass, depSubFareCard);
		homePage.clickContToPassenger();
		passengerdetailspage.addPassengerDetails(GetTestData.title, GetTestData.firstName, GetTestData.lastName,
				GetTestData.birthdayDate, GetTestData.nationality, GetTestData.passportNumber,
				GetTestData.passportExpiryDate, GetTestData.passportIssuingCountry);
		passengerdetailspage.addContactDetails(GetTestData.countryCode, GetTestData.phoneNumber, GetTestData.email);
		seatAndExtras.checkEVisaOptionIsPresent();
		seatAndExtras.clickGetEvisaBTN();
		eVisa.verifyEVisaApplicationPageIsOpened();
		eVisa.acceptTermsAndConditions();
		eVisa.clickProceedToApplicationBTN();

		// form

		eVisa.fillpersonalInfo(GetTestData.eVisa_Profession);
		eVisa.uploadPersonalPhoto(Constants.BOOKING_TESTDATA_EVISA_PERSONAL_PHOTO_PATH);
		eVisa.fillPassportAndNationalIdDetails(GetTestData.eVisa_Passport_Issue_Year, GetTestData.eVisa_Passport_Issue_Month,
				GetTestData.eVisa_Passport_Issue_DATE, GetTestData.eVisa_NationalID);
		eVisa.fillPassengerDetails(GetTestData.eVisa_BirthCity, GetTestData.eVisa_ResidenceCountry,
				GetTestData.eVisa_Address, GetTestData.eVisa_BirthCountry);
		eVisa.medicalInfoDetails();
		eVisa.clickSubmitBTN();
		
		eVisa.verifySuccessMessage(LayoutHeader.Anscillary_eVisa_SuccessMessage);
		String name = GetTestData.title + ". "+ GetTestData.firstName + " "+ GetTestData.lastName;
		eVisa.verifyFareDetails(name, GetTestData.eVisa_amount_perPerson, GetTestData.eVisa_totalAmount);
		eVisa.clickContinueBTN();
		// seatAndExtras.skipToPayment();
		// paymentpages.enterCardDetails();

	}

	// Round Trip Flight booking for E-Visa
	public void applyForEvisaRT(HomePage homePage, PassengerDetailsPage passengerdetailspage, PaymentPage paymentpages,
			FlightPage flightPage, SeatsAndExtras seatAndExtras, EvisaPage eVisa, String depFlightClass,
			String depSubFareCard, String retFlightClass, String retSubFareCard) throws Throwable {

		homePage.roundTripMethod(GetTestData.Origin_INTL, GetTestData.Destination_INTL);
		homePage.datePickerRT(GetTestData.departingMonth, GetTestData.departingDate, GetTestData.retunMonth,
				GetTestData.returnDate);
		homePage.clickSearchFlightsBTN();
		homePage.dontChangeBTNMethod();
		homePage.handleFlexibleDateSelector();
		flightPage.verifyFlightDetailsPageIsOpened();
	//	flightPage.visitSaudiEVisa();

		Thread.sleep(5000);
		System.out.println(depFlightClass + " ----  "+ depSubFareCard + "-----" + retFlightClass + "----" + retSubFareCard);
		flightPage.selectFareCardRT(depFlightClass, depSubFareCard, retFlightClass, retSubFareCard);
		homePage.clickContToPassenger();
		passengerdetailspage.verifyPassengerDetailsPageIsOpened();
		passengerdetailspage.addPassengerDetails(GetTestData.title, GetTestData.firstName, GetTestData.lastName,
				GetTestData.birthdayDate, GetTestData.nationality, GetTestData.passportNumber,
				GetTestData.passportExpiryDate, GetTestData.passportIssuingCountry);
		passengerdetailspage.addContactDetails(GetTestData.countryCode, GetTestData.phoneNumber, GetTestData.email);
		//seatAndExtras.checkEVisaOptionIsPresent();
		seatAndExtras.clickGetEvisaBTN();
		eVisa.verifyEVisaApplicationPageIsOpened();
		eVisa.selectStopOverFlight();
		eVisa.acceptTermsAndConditions();
		eVisa.clickProceedToApplicationBTN();

		// form

		eVisa.fillpersonalInfo(GetTestData.eVisa_Profession);
		eVisa.uploadPersonalPhoto(Constants.BOOKING_TESTDATA_EVISA_PERSONAL_PHOTO_PATH);
		eVisa.fillPassportAndNationalIdDetails(GetTestData.eVisa_Passport_Issue_Year,
				GetTestData.eVisa_Passport_Issue_Month, GetTestData.eVisa_Passport_Issue_DATE,
				GetTestData.eVisa_NationalID);
		eVisa.fillPassengerDetails(GetTestData.eVisa_BirthCity, GetTestData.eVisa_ResidenceCountry,
				GetTestData.eVisa_Address, GetTestData.eVisa_BirthCountry);
		eVisa.medicalInfoDetails();
		eVisa.clickSubmitBTN();

		//eVisa.verifySuccessMessage(LayoutHeader.Anscillary_eVisa_SuccessMessage);
		String name = GetTestData.title + ". " + GetTestData.firstName + " " + GetTestData.lastName;
		eVisa.verifyFareDetails(name, GetTestData.eVisa_amount_perPerson, GetTestData.eVisa_totalAmount);
		eVisa.clickContinueBTN();
		// seatAndExtras.skipToPayment();
		// paymentpages.enterCardDetails();

	}
	
	// remove E-visa in 'Seat and Extras' Page
	public void removeEvisa(SeatsAndExtras seatAndExtras) throws Throwable {

		seatAndExtras.checkEVisaOptionIsPresent();
		seatAndExtras.clickModifyEVisa();
		seatAndExtras.removeEvisa();

	}

	// Add Ancillaries mentioned in Test Data file
	public ArrayList<String[]> selectAncillaries(List<String> ancillaries, int noOfBounds, SeatsAndExtras seatAndExtras,
			FastTrackPage fastTrack, SeatSelectionPage seatSelection, ExtraBaggagePage extraBaggage,
			AltanfeethiVIPServicePage altanfeethiVIPService) throws Throwable {

		//Integer count[] = new Integer[4];
		ArrayList<String[]> arrayCollection = new ArrayList<>();
		
		int j = 0;

		for (int i = 0; i < ancillaries.size(); i++) 
		{
			if (ancillaries.get(i).contains(LayoutHeader.Anscillary_FastTrack_Heading)) {
				String[] addData = addFastTrack(noOfBounds, seatAndExtras, fastTrack);
				arrayCollection.add(j, addData);
				j++;
			} else if (ancillaries.get(i).contains(LayoutHeader.Anscillary_SeatSelection_Heading)) {
				String[] addData = SeatSelection(noOfBounds, seatAndExtras, seatSelection);
				arrayCollection.add(j, addData);
				j++;
			} else if (ancillaries.get(i).contains(LayoutHeader.Anscillary_ExtraBaggage_Heading)) {
				String[] addData = addExtraBaggage(noOfBounds, seatAndExtras, extraBaggage);
				arrayCollection.add(j, addData);
				j++;
			} else if (ancillaries.get(i).contains(LayoutHeader.Anscillary_Altanfeethi_Heading)) {
				String[] addData = addALTVIPService(noOfBounds, seatAndExtras, altanfeethiVIPService);
				arrayCollection.add(j, addData);
				j++;
			} else {
				throw new Exception("Ancillary not found !!!");
			}
		}
		return arrayCollection;
	}
	
	// MMB - Change Flight
	public void changeFlight(int noOfBound, MMBPage mmb, ChangeFlightPage changeFlight,
			String changeCondition) throws Exception {
		
		mmb.verifyMMBPageIsOpened();
		mmb.changeFlight();

		if (changeCondition.equalsIgnoreCase(LayoutHeader.ChangeFlightDate)) {
			if (noOfBound == 1)
			{
				changeFlight.clickChangeFlightDepart();
				System.out.println("******" + GetTestData.New_Departing_Month + "**** " + GetTestData.New_Departing_Date);
				changeFlight.datepickerCal(GetTestData.New_Departing_Month, GetTestData.New_Departing_Date);
			} else if (noOfBound == 2)
			{
				changeFlight.clickChangeFlightReturn();
				changeFlight.datepickerCal(GetTestData.New_Return_Month, GetTestData.New_Return_Date);
			}
			
			changeFlight.viewFlights();
			changeFlight.selectFareCardOW(GetTestData.Departure_Flight_Class_OW, GetTestData.Departure_Flight_SubClass_OW);
			
		} else if (changeCondition.equalsIgnoreCase(LayoutHeader.ChangeFlightRoute))
		{
			if (noOfBound == 1)
			{
				changeFlight.clickChangeFlightDepart();
				changeFlight.changeFlightRouteTO(GetTestData.New_Destination);
				changeFlight.selectFareCardOW(GetTestData.Departure_Flight_Class_OW, GetTestData.Departure_Flight_SubClass_OW);
				changeFlight.verifyFlightRoute(1, GetTestData.origin1, GetTestData.New_Destination);
			} else if (noOfBound == 2) 
			{
				changeFlight.clickChangeFlightDepart();
				changeFlight.changeFlightRouteTO(GetTestData.New_Destination);
				changeFlight.clickChangeFlightReturn();
				changeFlight.changeFlightRouteFROM(GetTestData.New_Destination);	
			}
			
			changeFlight.viewFlights();
			changeFlight.selectFareCardRT(GetTestData.Departure_Flight_Class_RT,
					GetTestData.Departure_Flight_SubClass_RT, GetTestData.Return_Flight_Class_RT, GetTestData.Return_Flight_SubClass_RT);
			changeFlight.verifyFlightRoute(2, GetTestData.origin1, GetTestData.New_Destination);

		} else {
			throw new Exception("Please check Change Flight condition !!!");
		}
		
		/*
		 * changeFlight.viewFlights();
		 * changeFlight.selectFareCardOW(GetTestData.Departure_Flight_Class_OW,
		 * GetTestData.Departure_Flight_SubClass_OW); if
		 * (changeCondition.equalsIgnoreCase(LayoutHeader.ChangeFlightRoute)) {
		 * changeFlight.verifyFlightRoute(1, GetTestData.origin1,
		 * GetTestData.New_Destination); }
		 */
		changeFlight.fareConfirmationPopup();
		changeFlight.proceedToPayment();
		changeFlight.changeFlightPayment(GetTestData.CardHolder_Name, GetTestData.PaymentMode);
	}
	
		// MMB - CheckIn Flight
		public void checkInFlight(int noOfBound, CheckInPage checkIn, String PNR) throws Exception {
			
			checkIn.verifyCheckInPageIsOpened(PNR);
			checkIn.startCheckIn();
			boolean checkInPopup = checkIn.checkInPopUpIsOpened();
			if(checkInPopup == false)
			{
				checkIn.complteMissingCheckINDetails();
				checkIn.completeCheckIn();
			}
			checkIn.acceptCheckInPopUp();
		}
}
