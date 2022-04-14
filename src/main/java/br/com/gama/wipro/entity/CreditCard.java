package br.com.gama.wipro.entity;

import java.util.Random;

public class CreditCard {

	private float balance;
	private String number;

	public CreditCard(float balance) {
		this.number = generateNumber();
		this.balance = balance;
	}

	public String getNumber() {
		return number;
	}

	public float getBalance() {
		return balance;
	}
	
	public String generateNumber() {
		return "5502" + " " + new Random().nextInt(1000, 9999) 
					  + " " + new Random().nextInt(1000, 9999) 
				      + " " + new Random().nextInt(1000, 9999);
	} 
	
	@Override
	public String toString() {
		return number;
	}
}