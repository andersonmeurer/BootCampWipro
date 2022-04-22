package br.com.gama.wipro.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public abstract class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	protected Integer number;

	protected Double balance;

	@OneToOne
	@JoinColumn(referencedColumnName = "id", name = "credit_card_id")
	protected CreditCard creditCard;

	public Account() {
	}

	public Account(Integer number, Double balance, CreditCard creditCard) {
		this.number = number;
		this.balance = balance;
		this.creditCard = creditCard;
	}

	public Integer getId() {
		return this.id;
	}

	public Integer getNumber() {
		return this.number;
	}

	public Double getBalance() {
		return this.balance;
	}

	public CreditCard getCreditCard() {
		return this.creditCard;
	}

	public void deposit(Double value) {
		this.balance += value;
	}

	public void withdraw(Double value) {
		this.balance -= value;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + 
			   "\n\n\tNúmero da conta: " + number + 
			   "\n\tSaldo: " + balance + 
			   "\n\tCartão de crédito: "+ creditCard +
			   "\n";
	}
}