package br.com.gama.wipro.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CurrentAccountTest {

	@Test
	void test() {
		try {
			Account account = new CurrentAccount(1234, 1500.0, new CreditCard(500.0), new Client("Cliente Teste 1"), true);
			assertEquals(1234, account.getNumber());
			assertEquals(1500.0, account.getBalance());
			account.withdraw(50.0);
			assertEquals(1450.0, account.getBalance());
			account.deposit(550.0);
			assertEquals(2000.0, account.getBalance());
			account.withdraw(1000.0);
			assertEquals(1000.0, account.getBalance());
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}

}
