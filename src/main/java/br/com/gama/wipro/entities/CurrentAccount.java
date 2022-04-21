package br.com.gama.wipro.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "db_currentAccount")
public class CurrentAccount extends Account implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer number;
	public CurrentAccount(Integer number, Double balance, CreditCard creditCard) {
		super(number, balance, creditCard);
	}

	@Override
	public void withdraw(Double value) {
		if (value<= this.balance) {
			super.withdraw(value);
		}
		
	}
	
	@Override
	public String toString() {
		return "\n\tConta Corrente"+ 
			   " \n\n\tNúmero da conta: " + number + 
		       " \n\tSaldo: " + balance + 
		       " \n\tCartão de crédito: "+ creditCard +
	           "\n";
	}
}