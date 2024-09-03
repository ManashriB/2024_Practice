package com.java.practice;

public class Main {

	public static void main(String[] args) {

	
	Account account1 = new Account (66181, 800000f, "Manashri");
	
	
	account1.setBalance(50000);
	account1.setName("Roshan");
	account1.setId(12);
	
	System.out.println(account1.getId());
	System.out.println(account1.getBalance());
	System.out.println(account1.getName());
	
   }
}