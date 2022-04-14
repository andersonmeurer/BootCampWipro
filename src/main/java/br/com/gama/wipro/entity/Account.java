package br.com.gama.wipro.entity;

public abstract class Account {

	protected int number;

	protected float balance;

	protected CreditCard creditCard;

	public Account(int number, float balance) {
		this.number = number;
		this.balance = balance;
		this.creditCard = new CreditCard(balance);
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
		this.balance += value;
	}

	protected void sacar(float value) {
		this.balance -= value;
	}

	@Override
	public String toString() {
		return "\tConta"+ 
			   " \n\n\tNúmero da conta: " + number + 
			   " \n\tSaldo: " + balance + 
			   " \n\tCartão de crédito: "+ creditCard +
		       "\n";
	}
}