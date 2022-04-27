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

  protected Boolean active;

	@OneToOne
	@JoinColumn(referencedColumnName = "id", name = "credit_card_id")
	protected CreditCard creditCard;

	public Account() {
		this.active = true;
	}

	public Account(Integer number, Double balance, CreditCard creditCard, Boolean active) {
		this.number = number;
		this.balance = balance;
		this.creditCard = creditCard;
		this.active = active;
	}

	public Account(Integer id, Integer number, Double balance, CreditCard creditCard, Boolean active) {
		this.id = id;
		this.number = number;
		this.balance = balance;
		this.creditCard = creditCard;
		this.active = active;
	}

//	public Integer getId() {
//		return this.id;
//	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public Boolean getActive () {
		return this.active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
}