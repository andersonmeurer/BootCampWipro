package br.com.gama.wipro.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountTest {

	@Test
	void test() {
		try {
			Account account = new CurrentAccount(123, 500f);
			assertEquals(123, account.getNumber());
			assertEquals(500f, account.getBalance());
			account.sacar(50);
			assertEquals(450f, account.getBalance());
			account.deposit(550);
			assertEquals(1000, account.getBalance());
			account.sacar(1000000);
			assertEquals(1000, account.getBalance());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}