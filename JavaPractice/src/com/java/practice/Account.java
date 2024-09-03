package com.java.practice;

public class Account {
	
	private int id;
	private String Name;
	private float Balance;
	
	public Account() {

   }
	
	public Account(float Balance, String Name) {
		this.Balance = Balance;
		this.Name = Name;
    }
	
	public Account(int id, float Balance, String Name) {
	this.Balance = Balance;
	this.Name = Name;
	this.id = id;
	}

  
	
	public int getId(){
	return id;
	  
	  }
	
	public String getName() {
		return Name;
		
		
	}
	
	public float getBalance() {
		return Balance;
		
	
}
public void setBalance(int amount) {
	if (this.Balance - amount >=10000)
this.Balance = this.Balance - amount;
		
	else 
		System.out.println("Insufficient balance");
}
	
	public void setName(String Name) {
		this.Name=Name;
	}
	
	public void setId (int Id) {
		// this.id=id;
		
		System.out.println("We can not change the account number");
	}
	
	
	
	
	
}