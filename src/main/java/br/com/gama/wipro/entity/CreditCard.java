package br.com.gama.wipro.entity;

public class CreditCard {

	private float balance;
	private int number;

	public CreditCard(int number, float balance) {
		this.number = number;
		this.balance = balance;
	}

	public int getNumber() {
		return number;
	}

	public float getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [saldo=" + balance + ", número=" + number + "]";
	}
}