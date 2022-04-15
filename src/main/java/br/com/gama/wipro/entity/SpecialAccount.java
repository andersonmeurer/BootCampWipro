package br.com.gama.wipro.entity;

public class SpecialAccount extends Account {

	private float overdraftLimit;

	public SpecialAccount(int number, float balance) {
		super(number, balance);
		overdraftLimit = (balance * 1.5f);
	}

	public float getOverdraftLimit() {
		return this.overdraftLimit;
	}

	@Override
	public void sacar(float valor) {
		if ((overdraftLimit + balance) >= valor) {
			super.sacar(valor);
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