package br.com.gama.wipro.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import br.com.gama.wipro.entities.CreditCard;

class CreditCardTest {

	@Test
	void testCreditCard() {
		try {
			CreditCard creditCard = new CreditCard(123.0);
			assertEquals(123, creditCard.getBalance());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
