package br.com.gama.wipro.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class CreditCardTest {

	@Test
	void testCreditCard() {
		try {
			CreditCard creditCard = new CreditCard(123);
			assertEquals(100, creditCard.getBalance());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
