package br.com.gama.wipro.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.gama.wipro.entities.CreditCard;
import br.com.gama.wipro.entities.CurrentAccount;
import br.com.gama.wipro.repositories.CreditCardRepository;
import br.com.gama.wipro.repositories.CurrentAccountRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private CreditCardRepository creditCardRepository;

	@Autowired
	private CurrentAccountRepository currentAccountRepository;

	@Override
	public void run(String... args) throws Exception {
//		CreditCard cd1 = new CreditCard( 100.0 );
//		CreditCard cd2 = new CreditCard( 100.0 );
//		CreditCard cd3 = new CreditCard( 100.0 );
//		
//		creditCardRepository.saveAll(Arrays.asList(cd1, cd2, cd3));
		
		CurrentAccount ca1 = new CurrentAccount(null, 100.0, new CreditCard(1000.0));
		CurrentAccount ca2 = new CurrentAccount(null, 100.0, new CreditCard(1000.0));
		CurrentAccount ca3 = new CurrentAccount(null, 100.0, new CreditCard(1000.0));
		
		currentAccountRepository.saveAll(Arrays.asList(ca1, ca2, ca3));

	}

}
