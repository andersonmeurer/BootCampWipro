package br.com.gama.wipro.services;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gama.wipro.entities.Client;
import br.com.gama.wipro.entities.CreditCard;
import br.com.gama.wipro.entities.CurrentAccount;
import br.com.gama.wipro.entities.dto.CurrentDto;
import br.com.gama.wipro.repositories.CreditCardRepository;
import br.com.gama.wipro.repositories.CurrentAccountRepository;
import br.com.gama.wipro.services.exceptions.ResourceNotFoundException;

@Service
public class CurrentAccountService {

	private CurrentAccountRepository repository;
	private CreditCardRepository creditCardRepository;
	private ClientService clientService;

	@Autowired
	public CurrentAccountService(CurrentAccountRepository repository, CreditCardRepository creditCardRepository, ClientService clientService) {
		this.repository = repository;
		this.creditCardRepository = creditCardRepository;
		this.clientService = clientService;
	}

	public List<CurrentAccount> findAll() {
		return repository.findAll();
	}

	public CurrentAccount findById(Integer id) {
		Optional<CurrentAccount> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public CurrentAccount create(CurrentDto obj) {

		CreditCard cc = new CreditCard(obj.getCreditCard().getBalance());
		creditCardRepository.save(cc);

		if (obj.getNumber() == null) {
			obj.setNumber(ThreadLocalRandom.current().nextInt(1000, 9999));
		}


		Client client = clientService.create(obj.getClient());
		CurrentAccount current = new CurrentAccount(obj.getNumber(), obj.getBalance(), cc, client, obj.getActive());

		return repository.save(current);
	}

	public Optional<CurrentAccount> update(Integer id, CurrentDto obj) {
		Optional<CurrentAccount> OObjOrigin = repository.findById(id);
		if (OObjOrigin.isPresent()) {
			CurrentAccount objOrigin = OObjOrigin.get();
			if (obj.getDeposit() > 0) {
				objOrigin.deposit(obj.getDeposit());
			}
			if (obj.getWithdraw() > 0) {
				objOrigin.withdraw(obj.getWithdraw());
			}
			return Optional.of(repository.save(objOrigin));
		}
		return Optional.empty();
	}

	public Optional<CurrentAccount> deactivate(Integer id) {
		Optional<CurrentAccount> oObjOrigin = repository.findById(id);

		if (oObjOrigin.isPresent()) {
			CurrentAccount objOrigin = oObjOrigin.get();
			objOrigin.getCreditCard().setActive(false);
			objOrigin.setActive(false);
			return Optional.of(repository.save(objOrigin));
		}
		return Optional.empty();
	}
}