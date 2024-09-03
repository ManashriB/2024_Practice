package com.saudia.qa.util;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.math.RoundingMode;


public class CommonMethodUtil {
	
	private static final DecimalFormat decfor = new DecimalFormat("0.00");
	public static String bookingReferenceOW = "";
	public static String bookingReferenceRT = "";
	public static String bookingReferenceMC = "";
	public static String numericBookingReference = "";
	public static String bookingDate = "";

	public static double getDoubleValueFromString(String inputAmount) {
		String str = inputAmount.replace(",", "");
		double amount = Double.valueOf(str);
		decfor.setRoundingMode(RoundingMode.DOWN);
		double serviceAmount = Double.parseDouble(decfor.format(amount));
		return serviceAmount;
	}

	public static String getCurrentDate() {
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
		String formattedDate = today.format(formatter);
		return formattedDate;
	}

}
