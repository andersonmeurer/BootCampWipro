package br.com.gama.wipro.entities.dto;

public class CurrentDto {

	private Integer number;

	private Double withdraw;

	private Double deposit;

	private Double balance;
	
	private Boolean active;

	private CreditCardDto creditCard;

	public CurrentDto() {
		this.withdraw = 0D;
		this.deposit = 0D;
		this.active = true;
	}

	public CurrentDto(Integer number, Double balance) {
		this.number = number;
		this.balance = balance;
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
}