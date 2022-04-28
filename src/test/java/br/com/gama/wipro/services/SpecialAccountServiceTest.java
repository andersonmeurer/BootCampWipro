package br.com.gama.wipro.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import br.com.gama.wipro.entities.dto.SpecialDto;
import br.com.gama.wipro.services.exceptions.ResourceNotFoundException;

@SpringBootTest
class SpecialAccountServiceTest {

	@Autowired
	private SpecialAccountService service;

	@Order(1)
	@Test
	void findAllTest() {
		assertEquals(0, service.findAll().size());
	}

	@Order(2)
	@Test
	void findByIdTest() {
		try {
			service.findById(0);
		} catch (Exception e) {
			assertEquals(new ResourceNotFoundException(0).getMessage(), e.getMessage());
		}
	}

	@Order(3)
	@Test
	void createTest() {
		try {
			SpecialDto obj = new SpecialDto(123, 100.00);
			assertEquals(1, service.create(obj).getId());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
