package br.com.gama.wipro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.net.URI;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpHeaders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import com.google.gson.Gson;

import br.com.gama.wipro.entities.CreditCard;
import br.com.gama.wipro.entities.CurrentAccount;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String URL;

	@BeforeEach
	public void before() {
		URL = "http://localhost:" + port + "/current/";
	}

	@Test
	void getCurrentAccountById() {
		try {
			String msg = this.restTemplate.getForObject(URL + "1", String.class);
			CurrentAccount currentAccount = new Gson().fromJson(msg, CurrentAccount.class);
			CurrentAccount expected = new CurrentAccount(1, currentAccount.getNumber(), 300.0, new CreditCard(1, 100.0, currentAccount.getCreditCard().getNumber()), true);

			assertEquals(expected.toString(), currentAccount.toString());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void criarCurrentAccount() {
		try {
			URI uri = new URI(URL);

			String numberCreditCard = new CreditCard().generateNumber();//apenas para gerar o numero
			CurrentAccount newCurrentAccount = new CurrentAccount(0, 9999, 1000D, new CreditCard(0, 2500D, numberCreditCard));
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-COM-PERSIST", "true");
			HttpEntity<CurrentAccount> request = new HttpEntity<>(newCurrentAccount, headers);
			ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
			assertEquals(201, result.getStatusCodeValue());

			String json = "{\"id\":4,\"number\":9999.0,\"balance\":1000.0,\"creditCard\":{\"id\":8,\"balance\":2500.0,\"number\":\"" + numberCreditCard + "\"}}";
			CurrentAccount expected = new Gson().fromJson(json, CurrentAccount.class);
			CurrentAccount resultOjb = new Gson().fromJson(result.getBody(), CurrentAccount.class);
			assertEquals(expected.toString(), resultOjb.toString());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}