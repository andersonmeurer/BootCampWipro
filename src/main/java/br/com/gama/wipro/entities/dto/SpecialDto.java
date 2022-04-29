package br.com.gama.wipro.entities.dto;

import br.com.gama.wipro.entities.Client;

public class SpecialDto {

	private Integer number;

	private Double withdraw;

	private Double deposit;

	private Double balance;
	
	private Boolean active;

	private ClientDto client;

	private CreditCardDto creditCard;


	public SpecialDto() {
		this.withdraw = 0D;
		this.deposit = 0D;
		this.client = new ClientDto("");
		this.active = true;
	}

	public SpecialDto(Integer number, Double balance, ClientDto client) {
		this.number = number;
		this.balance = balance;
		this.client = client;
		this.active = true;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public CreditCardDto getCreditCard() {
		return this.creditCard;
	}

	public Double getDeposit() {
		return this.deposit;
	}

	public Double getWithdraw() {
		return this.withdraw;
	}
	
	public Boolean getActive () {
		return this.active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setClient(ClientDto client) {
		this.client = client;
	}

	public ClientDto getClient() {
		return client;
	}
}