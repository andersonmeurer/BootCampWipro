package br.com.gama.wipro.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CorrenteTest {

	@Test
	void test() {
		try {
			Conta account = new Corrente(123, 500f);
			assertEquals(123, account.getNumero());
			assertEquals(500f, account.getSaldo());
			account.sacar(50);
			assertEquals(450f, account.getSaldo());
			account.depositar(550);
			assertEquals(1000, account.getSaldo());
			account.sacar(1000000);
			assertEquals(1000, account.getSaldo());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}