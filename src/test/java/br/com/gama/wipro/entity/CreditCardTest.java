package br.com.gama.wipro.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreditCardTest {

	@Test
	void testCreditCard() {
		try {
			CreditCard creditCard = new CreditCard(123, 100);
			assertEquals(123, creditCard.getNumber());
			assertEquals(100, creditCard.getBalance());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
