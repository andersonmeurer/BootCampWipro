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
	
	private Boolean active;
	
	public CreditCard () {
		this.active = true;
	}

	public CreditCard(Double balance) {
		this.number = generateNumber();
		this.balance = balance;
		this.active = true;
	}

	public CreditCard(Double balance, String number) {
		this.number = number;
		this.balance = balance;
		this.active = true;
	}

	public CreditCard(Integer id, Double balance, String number) {
		this.id = id;
		this.number = number;
		this.balance = balance;
		this.active = true;
	}

	public Integer getId() {
		return this.id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Double getBalance() {
		return balance;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public static String generateNumber() {
		return "5502" + " " + ThreadLocalRandom.current().nextInt(1000, 9999) 
					  + " " + ThreadLocalRandom.current().nextInt(1000, 9999) 
				      + " " + ThreadLocalRandom.current().nextInt(1000, 9999);
	}

	@Override
	public String toString() {
		return "CreditCard [id=" + this.id + ", balance=" + this.balance + ", number=" + this.number + ", active= " + this.active +"]";
	}
}