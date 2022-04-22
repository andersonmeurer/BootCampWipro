package br.com.gama.wipro.config;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.gama.wipro.entities.CreditCard;
import br.com.gama.wipro.entities.CurrentAccount;
import br.com.gama.wipro.entities.SpecialAccount;
import br.com.gama.wipro.repositories.CreditCardRepository;
import br.com.gama.wipro.repositories.CurrentAccountRepository;
import br.com.gama.wipro.repositories.SpecialAccountRepository;

@Configuration
//@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private CreditCardRepository creditCardRepository;

	@Autowired
	private CurrentAccountRepository currentAccountRepository;

	@Autowired
	private SpecialAccountRepository specialAccountRepository;

	@Override
	public void run(String... args) throws Exception {
		CreditCard cd1 = new CreditCard(100.0);
		CreditCard cd2 = new CreditCard(100.0);
		CreditCard cd3 = new CreditCard(100.0);
		CreditCard cd4 = new CreditCard(100.0);
		CreditCard cd5 = new CreditCard(100.0);
		CreditCard cd6 = new CreditCard(100.0);

		creditCardRepository.saveAll(Arrays.asList(cd1, cd2, cd3, cd4, cd5, cd6));

		CurrentAccount ca1 = new CurrentAccount(ThreadLocalRandom.current().nextInt(1000, 9999), 300D, cd1);
		CurrentAccount ca2 = new CurrentAccount(ThreadLocalRandom.current().nextInt(1000, 9999), 400D, cd2);
		CurrentAccount ca3 = new CurrentAccount(ThreadLocalRandom.current().nextInt(1000, 9999), 500D, cd3);

		currentAccountRepository.saveAll(Arrays.asList(ca1, ca2, ca3));

		SpecialAccount sa1 = new SpecialAccount(ThreadLocalRandom.current().nextInt(1000, 9999), 600D, cd4);
		SpecialAccount sa2 = new SpecialAccount(ThreadLocalRandom.current().nextInt(1000, 9999), 700D, cd5);
		SpecialAccount sa3 = new SpecialAccount(ThreadLocalRandom.current().nextInt(1000, 9999), 800D, cd6);

		specialAccountRepository.saveAll(Arrays.asList(sa1, sa2, sa3));
	}

}
