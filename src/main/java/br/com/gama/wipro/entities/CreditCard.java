package br.com.gama.wipro.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_creditcard")

public class CreditCard implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Double balance;
	
	private String number;
	
	public CreditCard () {
	}

	public CreditCard(Double balance) {
		this.number = generateNumber();
		this.balance = balance;
	}

	public Integer getId() {
		return this.id;
	}

	public String getNumber() {
		return number;
	}

	public Double getBalance() {
		return balance;
	}
	
	private String generateNumber() {
		return "5502" + " " + ThreadLocalRandom.current().nextInt(1000, 9999) 
					  + " " + ThreadLocalRandom.current().nextInt(1000, 9999) 
				      + " " + ThreadLocalRandom.current().nextInt(1000, 9999);
	} 
	
//	@Override
//	public String toString() {
//		return number;
//	}

	@Override
	public int hashCode() {
		return Objects.hash(id, number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCard other = (CreditCard) obj;
		return Objects.equals(id, other.id) && Objects.equals(number, other.number);
	}
}