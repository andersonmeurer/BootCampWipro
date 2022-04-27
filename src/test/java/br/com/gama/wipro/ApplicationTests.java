package br.com.gama.wipro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.net.URI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.gama.wipro.entities.CreditCard;
import br.com.gama.wipro.entities.CurrentAccount;
import br.com.gama.wipro.services.CurrentAccountService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	@Autowired
	private CurrentAccountService currentAccountService;

	@Autowired
	TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String URL;

	@BeforeEach
	public void before() {
		URL = "http://localhost:" + port + "/current/";
	}

	@Order(1)
	@Test
	public void criarCurrentAccount() {
		try {
			URI uri = new URI(URL);
			
			CreditCard cc = new CreditCard(0, 2500.0, CreditCard.generateNumber());
			CurrentAccount newCurrentAccount = new CurrentAccount(0, 9999, 1000.0, cc, true);
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-COM-PERSIST", "true");
			HttpEntity<CurrentAccount> request = new HttpEntity<>(newCurrentAccount, headers);
			ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
			assertEquals(201, result.getStatusCodeValue());
			
			String json = "{\"id\":1,\"number\":9999.0,\"balance\":1000.0,\"active\":true,\"creditCard\":{\"id\":1,\"balance\":2500.0,\"number\":\"" + cc.getNumber() + "\",\"active\":true}}";
			CurrentAccount expected = new Gson().fromJson(json, CurrentAccount.class);
			CurrentAccount resultOjb = new Gson().fromJson(result.getBody(), CurrentAccount.class);
			assertEquals(expected.toString(), resultOjb.toString());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Order(2)
	@Test
	void getCurrentAccountById() {
		try {
			String msg = this.restTemplate.getForObject(URL + "1", String.class);
			CurrentAccount currentAccount = new Gson().fromJson(msg, CurrentAccount.class);
			CurrentAccount expected = new CurrentAccount(1, currentAccount.getNumber(), 1000.0, new CreditCard(1, 2500.0, currentAccount.getCreditCard().getNumber()), true);

			assertEquals(expected.toString(), currentAccount.toString());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}


	@Order(3)
	@Test
	public void deleteCurrentAccount() {
		try {
//			assertEquals(1, currentAccountService.findById(1).getId());
//
//			CurrentDto dto = new CurrentDto();
//			dto.setActive(false);
//			HttpHeaders headers = new HttpHeaders();
//			headers.set("X-COM-PERSIST", "true");
//			HttpEntity<CurrentDto> request = new HttpEntity<>(dto, headers);
//
//			ResponseEntity<String> result = this.restTemplate.delete(URL + "1");
///*
//			CurrentAccount newCurrentAccount = new CurrentAccount(0, 9999, 1000.0, cc, true);
//			HttpHeaders headers = new HttpHeaders();
//			headers.set("X-COM-PERSIST", "true");
//			HttpEntity<CurrentAccount> request = new HttpEntity<>(newCurrentAccount, headers);
//			ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
//			assertEquals(201, result.getStatusCodeValue());
//*/
//			assertFalse(currentAccountService.findById(1).getActive());
////				assertEquals(new ResourceNotFoundException(4).getMessage(), e.getMessage());
			
//			CurrentDto dto = new CurrentDto();
//			dto.setActive(false);
//			Map<String, String> params = new HashMap<String, String>();
//			params.put("id", "1");
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.delete(new URI(URL + 1));
			
			assertFalse(currentAccountService.findById(1).getActive());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}