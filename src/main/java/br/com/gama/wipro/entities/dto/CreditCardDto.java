package br.com.gama.wipro.entities.dto;

public class CreditCardDto {

	private Double balance;

	public CreditCardDto() {
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