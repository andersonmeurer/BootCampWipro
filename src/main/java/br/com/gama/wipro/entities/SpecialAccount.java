package br.com.gama.wipro.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_special_account")
public class SpecialAccount extends Account {

	private Double overdraftLimit;
	
	public SpecialAccount() {
		this.active = true;
	}
	
	public SpecialAccount(Integer number, Double balance, CreditCard creditCard, Client client, Boolean active) {
		super(number, balance, creditCard, client, active);
		
		overdraftLimit = balance * 1.5;
	}

	public SpecialAccount(Integer number, Double balance, CreditCard creditCard, Client client) {
		super(number, balance, creditCard, client, true);
		
		overdraftLimit = balance * 1.5;
	}

	public Double getOverdraftLimit() {
		return this.overdraftLimit;
	}

	@Override
	public void withdraw(Double value) {
		if ((overdraftLimit+ balance) >= value) {
			super.withdraw(value);
		}
	}
}