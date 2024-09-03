package com.java.practice;

public class Encapsulation {

	private int ticketId;
	private String passengerName;
	private float walletBalance;
	
	
public int getTicketId() {
	
	return ticketId;
}
		public String getPassengerName() {
			return passengerName;
		}
		
		public float getWalletBalance() {
			return walletBalance;
		}
	
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	
	public void setWalletBalance(float walletBalance) {
		this.walletBalance = walletBalance;
	}

public static void main(String[] args) {
	
	
	Encapsulation s1 = new Encapsulation();
	s1.setPassengerName("manashri");
	s1.setTicketId(10);
	
	System.out.println(s1.getPassengerName());
	System.out.println(s1.getWalletBalance());
}


	
}



