package br.com.gama.wipro.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpecialAccountTest {

	private SpecialAccount spa;

	@BeforeEach
	public void SpecialAccountTestInit() {
		spa = new SpecialAccount(1234, 1500.0, new CreditCard(500.0), new Client("Cliente Teste 1"));
	}

	@Test
	void testWithdraw() {
		spa.withdraw(500D);
		assertEquals(1000, spa.getBalance());

	}

	@Test
	void testSpecialAccount() {
		SpecialAccount spa0 = new SpecialAccount();
		assertEquals(null, spa0.getNumber());
		assertEquals(null, spa0.getBalance());
		assertEquals(null, spa0.getOverdraftLimit());
		assertEquals(true, spa0.getActive());

	}

	@Test
	void testSpecialAccountIntegerDoubleCreditCardBoolean() {
		SpecialAccount spa1 = new SpecialAccount(1234, 10000.0, new CreditCard(), new Client("Cliente Teste 1"), false);
		assertEquals(1234, spa1.getNumber());
		assertEquals(10000.0, spa1.getBalance());
		assertEquals(15000.0, spa1.getOverdraftLimit());
		assertEquals(false, spa1.getActive());

	}

	@Test
	void testSpecialAccountIntegerDoubleCreditCard() {
		SpecialAccount spa3 = new SpecialAccount(1234, 1500.0, new CreditCard(500.0), new Client("Cliente Teste 1"));
		assertEquals(1234, spa3.getNumber());
		assertEquals(1500.0, spa3.getBalance());
		spa3.withdraw(50.0);
		assertEquals(1450.0, spa3.getBalance());
		spa3.deposit(550.0);
		assertEquals(2000.0, spa3.getBalance());
		spa3.withdraw(1000.0);
		assertEquals(1000.0, spa3.getBalance());
		assertEquals(2250.0, spa3.getOverdraftLimit());
		assertEquals(true, spa3.getActive());

	}

	@Test
	void testGetOverdraftLimit() {
		assertEquals(2250.0, spa.getOverdraftLimit());
		assertNotEquals(220.0, spa.getOverdraftLimit());

	}

	@Test
	void testGetNumber() {
		assertEquals(1234, spa.getNumber());

	}

	@Test
	void testGetBalance() {
		assertEquals(1500, spa.getBalance());

	}

	@Test
	void testGetCreditCard() {
		System.out.println(spa.getCreditCard());
		CreditCard cd = spa.getCreditCard();
		assertEquals(null, cd.getId());
		assertEquals(500, cd.getBalance());

	}

	@Test
	void testDeposit() {
		spa.deposit(500.0);
		assertEquals(2000, spa.getBalance());

	}

	@Test
	void testGetActive() {
		assertEquals(true, spa.getActive());

	}

	@Test
	void testSetActive() {
		spa.setActive(false);
		assertEquals(false, spa.getActive());

	}
}
