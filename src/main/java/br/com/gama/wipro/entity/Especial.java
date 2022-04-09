package br.com.gama.wipro.entity;

public class Especial extends Conta {

	private float limite;

	public Especial(int numero, float saldo) {
		super(numero, saldo);
		limite = (saldo * 1.5f);
	}

	public float getLimite() {
		return this.limite;
	}

	@Override
	public void sacar(float valor) {
		if ((limite + saldo) >= valor) {
			super.sacar(valor);
		}
	}
}