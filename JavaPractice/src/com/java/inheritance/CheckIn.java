package com.java.inheritance;

public class CheckIn extends ManageMyBooking {

	int MandGprice = 112;
	int FastTrack = 45;

	void MeetAndGreet() {

		System.out.println("User can add Meet and Greet service");

	}
@Override
	void Baggage() {

		System.out.println("User can add Fast Track service");

	}
}
