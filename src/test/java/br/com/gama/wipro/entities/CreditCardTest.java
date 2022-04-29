package br.com.gama.wipro.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.gama.wipro.entities.CreditCard;

class CreditCardTest {

	private CreditCard cd; 
	@BeforeEach
	public void CreditCardTestInit() {
		cd = new CreditCard(1500.0);	
	}
	@Test
	void testCreditCard() {
		try {
			CreditCard creditCard = new CreditCard();
			System.out.println(creditCard.getBalance());
			assertEquals(null, creditCard.getBalance());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testCreditCardDouble() {
		try {
			CreditCard creditCard = new CreditCard(123.0);
			assertEquals(123, creditCard.getBalance());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}


	@Test
	void testGetNumber() {
		try {
			String number = cd.getNumber();
			assertEquals(number, cd.getNumber());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testGetBalance() {
		try {
			assertEquals(1500D, cd.getBalance());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testGetActive() {
		try {
			assertEquals(true, cd.getActive());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testSetActive() {
		try {
			assertEquals(true, cd.getActive());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
