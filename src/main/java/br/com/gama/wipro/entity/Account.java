package br.com.gama.wipro.entity;

public abstract class Account {

	protected int number;

	protected float balance;

	protected CreditCard creditCard;

	public Account(int number, float balance) {
		this.number = number;
		this.balance = balance;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public int getNumber() {
		return number;
	}

	public float getBalance() {
		return balance;
	}

	protected void deposit(float value) {
		this.balance = (balance + value);
	}

	protected void sacar(float value) {
		this.balance = (balance - value);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [número=" + number + ", saldo=" + balance + ", cartao de crédito="
				+ creditCard + "]";
	}
}