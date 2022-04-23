package br.com.gama.wipro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.google.gson.Gson;

import br.com.gama.wipro.entities.CreditCard;
import br.com.gama.wipro.entities.CurrentAccount;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@Test
	void contextLoads() {
		try {
			String msg = this.restTemplate.getForObject("http://localhost:" + port + "/current/1", String.class);
			String json = "{\"id\":1,\"number\":9589,\"balance\":300.0,\"creditCard\":{\"id\":1,\"balance\":100.0,\"number\":\"5502 4611 9139 9752\"}}";
			CurrentAccount expected = new CurrentAccount(1, 9589, 300.0, new CreditCard(1, 100.0, "5502 4611 9139 9752"));
			Gson gson = new Gson();
			CurrentAccount currentAccount = gson.fromJson(json, CurrentAccount.class);
			assertEquals(expected.toString(), currentAccount.toString());

//			String msg = this.restTemplate.putForObject("http://localhost:" + port + "/current/1", String.class);
			

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}