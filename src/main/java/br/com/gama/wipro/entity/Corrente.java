package br.com.gama.wipro.entity;

public class Corrente extends Conta {

	public Corrente(int numero, float saldo) {
		super(numero, saldo);
	}

	@Override
	public void sacar(float valor) {
		if (valor <= this.saldo) {
			super.sacar(valor);
		}
	}
}