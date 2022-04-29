package br.com.gama.wipro.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_current_account")
public class CurrentAccount extends Account {

	public CurrentAccount() {
		this.active = true;
	}

	public CurrentAccount(Integer id, Integer number, Double balance, CreditCard creditCard, Client client, Boolean active) {
		super(id, number, balance, creditCard, client, active);
	}

	public CurrentAccount(Integer number, Double balance, CreditCard creditCard, Client client, Boolean active) {
		super(number, balance, creditCard, client, active);
	}
	
	public CurrentAccount(Integer number, Double balance, CreditCard creditCard, Client client) {
		super(number, balance, creditCard, client, true);
	}

	@Override
	public void withdraw(Double value) {
		if (value <= this.balance) {
			super.withdraw(value);
		}
	}

	@Override
	public String toString() {
		return "CurrentAccount [id= " + this.id + ", number= " + this.number + ", balance= " + this.balance
				+ ", creditCard= " + this.creditCard + "active= " + this.active +"]";
	}
}