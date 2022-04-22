package br.com.gama.wipro.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_special_account")
public class SpecialAccount extends Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Integer number;

	private Double overdraftLimit;
	
	public SpecialAccount() {
	}
	
	public SpecialAccount(Integer id, Integer number, Double balance, CreditCard creditCard) {
		super(number, balance, new CreditCard(balance));
		
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
	
	@Override
	public String toString() {
		return "\n\tConta Especial"+ 
			   " \n\n\tNúmero da conta: " + number + 
			   " \n\tSaldo: " + balance + 
			   " \n\tCartão de crédito: "+ creditCard +
			   "\n";
	}
}