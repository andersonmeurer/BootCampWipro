package br.com.gama.wipro.entities;

public class SpecialAccount extends Account {

	private Double overdraftLimit;

	public SpecialAccount(int number, Double balance, CreditCard creditCard) {
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