package br.com.gama.wipro.entity;

public class CurrentAccount extends Account {

	public CurrentAccount(int number, float balance) {
		super(number, balance);
	}

	@Override
	public void sacar(float value) {
		if (value <= this.balance) {
			super.sacar(value);
		}
	}
	
	@Override
	public String toString() {
		return "\tConta Corrente"+ 
			   " \n\n\tNúmero da conta: " + number + 
		       " \n\tSaldo: " + balance + 
		       " \n\tCartão de crédito: "+ creditCard +
	           "\n";
	}
}