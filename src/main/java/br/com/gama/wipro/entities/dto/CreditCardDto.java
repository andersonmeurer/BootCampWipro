package br.com.gama.wipro.entities.dto;

public class CreditCardDto {

	private Double balance;

	private String number;

	public CreditCardDto() {
		balance = 0.0;
		number = "";
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public CreditCardDto(Double balance) {
		this.balance = balance;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
}