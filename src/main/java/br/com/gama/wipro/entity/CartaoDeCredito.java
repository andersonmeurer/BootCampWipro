package br.com.gama.wipro.entity;

public class CartaoDeCredito {

	private float saldo;
	private int numero;

	public CartaoDeCredito(int numero, float saldo) {
		this.numero = numero;
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public float getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [saldo=" + saldo + ", numero=" + numero + "]";
	}
}