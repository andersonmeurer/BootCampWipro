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
		cd = new CreditCard(1234, 1500.0, "1234 1234 1234 1234");	
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
	void testCreditCardDoubleString() {
		try {
			CreditCard cd = new CreditCard(123.0, "1234 1234 1234 1234");
			assertEquals(123, cd.getBalance());
			assertEquals("1234 1234 1234 1234", cd.getNumber());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testCreditCardIntegerDoubleString() {
		try {
			CreditCard cd = new CreditCard(1234, 123.0, "1234 1234 1234 1234");
			System.out.println(cd.getNumber());
			assertEquals(1234, cd.getId());
			assertEquals(123.0, cd.getBalance());
			assertEquals("1234 1234 1234 1234", cd.getNumber());
			assertEquals(true, cd.getActive());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}


	@Test
	void testGetId() {
		try {
			System.out.println(cd.getId());
			assertEquals(1234, cd.getId());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testGetNumber() {
		try {
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testGetBalance() {
		try {
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testGetActive() {
		try {
			
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
