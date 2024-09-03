package com.saudia.qa.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.saudia.qa.config.Constants;

public class GetTestData {

	/******************* Booking ********************/
	public static String origin1, destination1, Route_Bound2_MC, Route_Bound3_MC, Route_Bound4_MC, Route_Bound5_MC, Route_Bound6_MC, searchCountryText, departingMonth, departingDate, title, retunMonth , returnDate;
	public static String firstName, lastName, birthdayDate, nationality, passportNumber, passportExpiryDate, passportIssuingCountry;
	public static String countryCode, phoneNumber, email;
	public static String Departing_Month_Bound1_MC, Departing_Month_Bound2_MC, Departing_Month_Bound3_MC,Departing_Month_Bound4_MC , Departing_Month_Bound5_MC, Departing_Month_Bound6_MC;
	public static String Departing_Date_Bound1_MC, Departing_Date_Bound2_MC, Departing_Date_Bound3_MC, Departing_Date_Bound4_MC, Departing_Date_Bound5_MC, Departing_Date_Bound6_MC;
	public static String Flight_Class_Guest, Flight_Class_Business, Flight_Class_First;
	public static String guest_subFareCard_Basic , guest_subFareCard_Saver , guest_subFareCard_SemiFlex , guest_SubFareCard_Flex;
	public static String business_subFareCard_Basic, business_subFareCard_SemiFlex , business_subFareCard_Flex;
	public static String first_subFareCard_SemiFlex , first_subFareCard_Flex, ExtraBaggage_Amount_DOM, ExtraBags_MAX_Allowed_Count, ExtraBags_Allowed_Weight;
	public static String Departure_Flight_Class_OW, Departure_Flight_SubClass_OW, Departure_Flight_Class_RT, Departure_Flight_SubClass_RT, Return_Flight_Class_RT, Return_Flight_SubClass_RT;
	public static String Flight_Class_MC, Flight_SubClass_MC,Departure_Flight_Class_Bound2_MC,Departure_Flight_SubClass_Bound2_MC,Return_Flight_Class_Bound2_MC,Return_Flight_SubClass_Bound2_MC;
	public static String FastTrack_Amount_DOM , Altanfeethi_Amount_DOM ,Altanfeethi_VIP_Service_Name, eVisa_Profession;
	public static String Departure_Flight_SubClass_OW_INTL, Departure_Flight_Class_OW_INTL, eVisa_Duration, Origin_INTL, Destination_INTL;
	public static String eVisa_NationalID, eVisa_BirthCountry, eVisa_BirthCity, eVisa_ResidenceCountry, eVisa_Address, eVisa_Passport_Issue_Year, eVisa_Passport_Issue_Month, eVisa_Passport_Issue_DATE, eVisa_amount_perPerson, eVisa_totalAmount;
	public static String Amex_CardNumber, Amex_CardExpiry, Amex_CardCVV, Visa_CardNumber, Visa_CardExpiry, Visa_CardCVV, MasterCard_CardNumber, MasterCard_CardExpiry, MasterCard_CardCVV, Mada_CardNumber, Mada_CardExpiry, Mada_CardCVV, CardHolder_Name, PaymentMode;
	public static String  Seat_Service_Amount, Select_Ancillaries;
	
	public static List<String> departingMonthDataMC = new ArrayList<>();
	public static List<String> departingDateDataMC = new ArrayList<>();
	
	
	/******************* MMB ********************/
	
	public static String New_Origin, New_Destination, New_Departing_Month, New_Departing_Date, New_Return_Month, New_Return_Date;
	
		
	public static void getBookingTestData(ExcelUtill excel, String sheetName, String excelSheetColumn) 
	{
		try {
			origin1 = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_ORIGIN,excelSheetColumn,sheetName);
			destination1 = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DESTINATION,excelSheetColumn,sheetName);
			Origin_INTL = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_ORIGIN_INTL,excelSheetColumn,sheetName);
			Destination_INTL = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DESTINATION_INTL,excelSheetColumn,sheetName);
			searchCountryText=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_SEARCH_COUNTRY,excelSheetColumn,sheetName);
			departingMonth=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPARTING_MONTH,excelSheetColumn,sheetName);
			departingDate=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPARTING_DATE,excelSheetColumn,sheetName);
			returnDate = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_RETURN_DATE,excelSheetColumn,sheetName);
			Departure_Flight_Class_OW = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPARTURE_FLIGHT_CLASS_OW, excelSheetColumn, sheetName);
			Departure_Flight_SubClass_OW = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPARTURE_FLIGHT_SUBCLASS_OW, excelSheetColumn, sheetName);
			Departure_Flight_Class_RT = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPARTURE_FLIGHT_CLASS_RT, excelSheetColumn, sheetName);
			Departure_Flight_SubClass_RT = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPARTURE_FLIGHT_SUBCLASS_RT, excelSheetColumn, sheetName);
			Return_Flight_Class_RT = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_RETURN_FLIGHT_CLASS_RT, excelSheetColumn, sheetName);
			Return_Flight_SubClass_RT = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_RETURN_FLIGHT_SUBCLASS_RT, excelSheetColumn, sheetName);
			Flight_Class_MC=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_FLIGHT_CLASS_MC, excelSheetColumn, sheetName);
			Flight_SubClass_MC = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_FLIGHT_SUBCLASS_MC, excelSheetColumn, sheetName);
			Departure_Flight_Class_Bound2_MC =excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPART_FLIGHT_CLASS_MC_BOUND2, excelSheetColumn, sheetName); 
			Departure_Flight_SubClass_Bound2_MC =excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPART_SUBFLIGHT_CLASS_MC_BOUND2, excelSheetColumn, sheetName);
			Return_Flight_Class_Bound2_MC =excel.getValueFromExcel(Constants.BOOKING_TESTDATA_RETURN_FLIGHT_CLASS_MC_BOUND2, excelSheetColumn, sheetName);
			Return_Flight_SubClass_Bound2_MC =excel.getValueFromExcel(Constants.BOOKING_TESTDATA_RETURN_SUBFLIGHT_CLASS_MC_BOUND2, excelSheetColumn, sheetName);
			Departure_Flight_Class_OW_INTL=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPARTURE_FLIGHT_CLASS_OW_INTL, excelSheetColumn, sheetName);
			Departure_Flight_SubClass_OW_INTL=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPARTURE_FLIGHT_SUBCLASS_OW_INTL, excelSheetColumn, sheetName);
			eVisa_Duration = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_EVISA_DURATION,excelSheetColumn,sheetName);
			eVisa_Profession = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_EVISA_PROFESSION,excelSheetColumn,sheetName);
			eVisa_NationalID = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_EVISA_NATIONALID,excelSheetColumn,sheetName);
			eVisa_BirthCountry = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_EVISA_BIRTH_COUNTRY,excelSheetColumn,sheetName);
			eVisa_BirthCity = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_EVISA_BIRTH_CITY,excelSheetColumn,sheetName);
			eVisa_ResidenceCountry = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_EVISA_RESIDENCE_COUNTRY,excelSheetColumn,sheetName);
			eVisa_Address = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_EVISA_ADDRESS,excelSheetColumn,sheetName);
			eVisa_Passport_Issue_Year = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_EVISA_PASSPORT_ISSUE_YEAR,excelSheetColumn,sheetName);
			eVisa_Passport_Issue_Month = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_EVISA_PASSPORT_ISSUE_MONTH,excelSheetColumn,sheetName);
			eVisa_Passport_Issue_DATE = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_EVISA_PASSPORT_ISSUE_DATE,excelSheetColumn,sheetName);
			eVisa_amount_perPerson= excel.getValueFromExcel(Constants.BOOKING_TESTDATA_EVISA_AMOUNT_PERPERSON,excelSheetColumn,sheetName);
			eVisa_totalAmount= excel.getValueFromExcel(Constants.BOOKING_TESTDATA_EVISA_TOTALAMOUNT,excelSheetColumn,sheetName);
			retunMonth = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_RETURN_MONTH,excelSheetColumn,sheetName);
			title=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_TITLE,excelSheetColumn,sheetName);
			firstName=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_FIRSTNAME,excelSheetColumn,sheetName);
			lastName=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_LASTNAME,excelSheetColumn,sheetName);
			birthdayDate=excel.getValueFromExcel( Constants.BOOKING_TESTDATA_BIRTH_DATE,excelSheetColumn,sheetName);
			nationality=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_NATIONALITY,excelSheetColumn,sheetName);
			passportNumber=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_PASSPORT_NUMBER,excelSheetColumn,sheetName);
			passportExpiryDate=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_PASSPORT_EXPIRYDATE,excelSheetColumn,sheetName);
			passportIssuingCountry=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_PASSPORT_ISSUING_COUNTRY,excelSheetColumn,sheetName);
			countryCode=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_COUNTRY_CODE,excelSheetColumn,sheetName);
			phoneNumber=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_PHONE_NUMBER,excelSheetColumn,sheetName);
			email=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_EMAIL_ADDRESS,excelSheetColumn,sheetName);
			Route_Bound2_MC = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_ROUTE_BOUND2_MC, excelSheetColumn, sheetName);
			Route_Bound3_MC = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_ROUTE_BOUND3_MC, excelSheetColumn, sheetName);
			Route_Bound4_MC = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_ROUTE_BOUND4_MC, excelSheetColumn, sheetName);
			Route_Bound5_MC = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_ROUTE_BOUND5_MC, excelSheetColumn, sheetName);
			Route_Bound6_MC = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_ROUTE_BOUND6_MC, excelSheetColumn, sheetName);
			Departing_Month_Bound1_MC=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPARTING_MONTH_BOUND1_MC,excelSheetColumn,sheetName);
			Departing_Date_Bound1_MC=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPARTING_DATE_BOUND1_MC,excelSheetColumn,sheetName);
			Departing_Month_Bound2_MC=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPARTING_MONTH_BOUND2_MC,excelSheetColumn,sheetName);
			Departing_Date_Bound2_MC=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPARTING_DATE_BOUND2_MC,excelSheetColumn,sheetName);
			Departing_Month_Bound3_MC=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPARTING_MONTH_BOUND3_MC,excelSheetColumn,sheetName);
			Departing_Date_Bound3_MC=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPARTING_DATE_BOUND3_MC,excelSheetColumn,sheetName);
			Departing_Month_Bound4_MC=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPARTING_MONTH_BOUND4_MC,excelSheetColumn,sheetName);
			Departing_Date_Bound4_MC=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPARTING_DATE_BOUND4_MC,excelSheetColumn,sheetName);
			Departing_Month_Bound5_MC=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPARTING_MONTH_BOUND5_MC,excelSheetColumn,sheetName);
			Departing_Date_Bound5_MC=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPARTING_DATE_BOUND5_MC,excelSheetColumn,sheetName);
			Departing_Month_Bound6_MC=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPARTING_MONTH_BOUND6_MC,excelSheetColumn,sheetName);
			Departing_Date_Bound6_MC=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_DEPARTING_DATE_BOUND6_MC,excelSheetColumn,sheetName);
			departingMonthDataMC.addAll(Arrays.asList(GetTestData.Departing_Month_Bound2_MC, GetTestData.Departing_Month_Bound2_MC,
							GetTestData.Departing_Month_Bound3_MC, GetTestData.Departing_Month_Bound4_MC,
							GetTestData.Departing_Month_Bound5_MC, GetTestData.Departing_Month_Bound6_MC));
			departingDateDataMC.addAll(Arrays.asList(GetTestData.Departing_Date_Bound1_MC, GetTestData.Departing_Date_Bound2_MC,
							GetTestData.Departing_Date_Bound3_MC, GetTestData.Departing_Date_Bound4_MC,
							GetTestData.Departing_Date_Bound5_MC, GetTestData.Departing_Date_Bound6_MC));
			Flight_Class_Guest=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_FLIGHTCLASS_GUEST, excelSheetColumn,sheetName);
			Flight_Class_Business=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_FLIGHTCLASS_BUSINESS, excelSheetColumn, sheetName);
			Flight_Class_First=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_FLIGHTCLASS_FIRST, excelSheetColumn, sheetName);
			guest_subFareCard_Basic = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_GUEST_SUBFARECARD_BASIC, excelSheetColumn, sheetName);
			guest_subFareCard_Saver = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_GUEST_SUBFARECARD_SAVER, excelSheetColumn, sheetName);
			guest_subFareCard_SemiFlex = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_GUEST_SUBFARECARD_SEMIFLEX, excelSheetColumn, sheetName);
			guest_SubFareCard_Flex = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_GUEST_SUBFARECARD_FLEX, excelSheetColumn, sheetName);
			business_subFareCard_Basic = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_BUSINESS_SUBFARECARD_BASIC, excelSheetColumn, sheetName);
			business_subFareCard_SemiFlex = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_BUSINESS_SUBFARECARD_SEMIFLEX, excelSheetColumn, sheetName);
			business_subFareCard_Flex = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_BUSINESS_SUBFARECARD_FLEX, excelSheetColumn, sheetName);
			first_subFareCard_SemiFlex = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_FIRST_SUBFARECARD_SEMIFLEX, excelSheetColumn, sheetName);
			first_subFareCard_Flex = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_FIRST_SUBFARECARD_FLEX, excelSheetColumn, sheetName);
			ExtraBaggage_Amount_DOM=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_EXTRABAGGAGE_AMOUNT_DOM, excelSheetColumn, sheetName);
			ExtraBags_MAX_Allowed_Count=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_EXTRABAGS_MAX_ALLOWED_COUNT, excelSheetColumn, sheetName);
			ExtraBags_Allowed_Weight=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_EXTRABAGS_ALLOWED_WEIGHT, excelSheetColumn, sheetName);
			FastTrack_Amount_DOM=excel.getValueFromExcel(Constants.BOOKING_TESTDATA_FastTrack_Amount_DOM, excelSheetColumn, sheetName);
			Altanfeethi_Amount_DOM = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_ALTANFEETHI_AMOUNT_DOM, excelSheetColumn, sheetName);
			Altanfeethi_VIP_Service_Name = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_ALTANFEETHI__VIP_SERVICE_NAME, excelSheetColumn, sheetName);
			Seat_Service_Amount  = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_SEAT_AMOUNT, excelSheetColumn, sheetName);
			Select_Ancillaries  = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_SELECT_ANCILLARIES, excelSheetColumn, sheetName);
			Amex_CardNumber = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_PAYMENT_AMEX_CARDNUMBER, excelSheetColumn, sheetName);
			Amex_CardExpiry = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_PAYMENT_AMEX_CARDEXPIRY, excelSheetColumn, sheetName);
			Amex_CardCVV = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_PAYMENT_AMEX_CARDCVV, excelSheetColumn, sheetName);
			Visa_CardNumber = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_PAYMENT_VISA_CARDNUMBER, excelSheetColumn, sheetName);
			Visa_CardExpiry = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_PAYMENT_VISA_CARDEXPIRY, excelSheetColumn, sheetName);
			Visa_CardCVV = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_PAYMENT_VISA_CARDCVV, excelSheetColumn, sheetName);
			MasterCard_CardNumber = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_PAYMENT_MASTERCARD_CARDNUMBER, excelSheetColumn, sheetName);
			MasterCard_CardExpiry = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_PAYMENT_MASTERCARD_CARDEXPIRY, excelSheetColumn, sheetName);
			MasterCard_CardCVV = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_PAYMENT_MASTERCARD_CARDCVV, excelSheetColumn, sheetName);
			Mada_CardNumber = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_PAYMENT_MADA_CARDNUMBER, excelSheetColumn, sheetName);
			Mada_CardExpiry = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_PAYMENT_MADA_CARDEXPIRY, excelSheetColumn, sheetName);
			Mada_CardCVV = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_PAYMENT_MADA_CARDCVV, excelSheetColumn, sheetName);
			CardHolder_Name = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_PAYMENT_CARDHOLDER_NAME, excelSheetColumn, sheetName);
			PaymentMode = excel.getValueFromExcel(Constants.BOOKING_TESTDATA_PAYMENT_PAYMENTMODE, excelSheetColumn, sheetName);
		
		}
		catch (IOException e)
		{
			Log.info("Error while fetching Booking data from excel in GetTestData class");
			e.printStackTrace();
		}
		
		
	}

	public static void getMMBTestData(ExcelUtill excel, String mmbTestdataExcelsheet, String mmbTestdataColumn1) {
		
		try {
			New_Origin = excel.getValueFromExcel(Constants.MMB_TESTDATA_NEW_ORIGIN,mmbTestdataColumn1,mmbTestdataExcelsheet);
			New_Destination = excel.getValueFromExcel(Constants.MMB_TESTDATA_NEW_DESTINATION,mmbTestdataColumn1,mmbTestdataExcelsheet);
			New_Departing_Month = excel.getValueFromExcel(Constants.MMB_TESTDATA_NEW_DEPARTING_MONTH,mmbTestdataColumn1,mmbTestdataExcelsheet);
			New_Return_Month = excel.getValueFromExcel(Constants.MMB_TESTDATA_NEW_RETURN_MONTH,mmbTestdataColumn1,mmbTestdataExcelsheet);
			New_Return_Date = excel.getValueFromExcel(Constants.MMB_TESTDATA_NEW_RETURN_DATE,mmbTestdataColumn1,mmbTestdataExcelsheet);
			New_Departing_Date = excel.getValueFromExcel(Constants.MMB_TESTDATA_NEW_DEPARTING_DATE,mmbTestdataColumn1,mmbTestdataExcelsheet);
		} catch (IOException e) {
			Log.info("Error while fetching MMB data from excel in GetTestData class ");
			e.printStackTrace();
		}
		
	}
	
}
