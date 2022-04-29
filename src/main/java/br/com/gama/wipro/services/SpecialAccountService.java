package br.com.gama.wipro.services;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gama.wipro.entities.Client;
import br.com.gama.wipro.entities.CreditCard;
import br.com.gama.wipro.entities.SpecialAccount;
import br.com.gama.wipro.entities.dto.CurrentDto;
import br.com.gama.wipro.entities.dto.SpecialDto;
import br.com.gama.wipro.repositories.CreditCardRepository;
import br.com.gama.wipro.repositories.SpecialAccountRepository;
import br.com.gama.wipro.services.exceptions.ResourceNotFoundException;

@Service
public class SpecialAccountService {

	private SpecialAccountRepository repository;
	private CreditCardRepository creditCardRepository;
	private ClientService clientService;

	@Autowired
	public SpecialAccountService(SpecialAccountRepository repository, CreditCardRepository creditCardRepository, ClientService clientService) {
		this.repository = repository;
		this.creditCardRepository = creditCardRepository;
		this.clientService = clientService;
	}

	public List<SpecialAccount> findAll() {
		return repository.findAll();
	}

	public SpecialAccount findById(Integer id) {
		Optional<SpecialAccount> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public SpecialAccount create(SpecialDto obj) {

		CreditCard cc = new CreditCard(obj.getCreditCard().getBalance(), CreditCard.generateNumber());
		creditCardRepository.save(cc);

		if (obj.getNumber() == null) {
			obj.setNumber(ThreadLocalRandom.current().nextInt(1000, 9999));
		}

		// próxima sprint
		// validar se numero da conta já existe

		Client client = clientService.create(obj.getClient());
		SpecialAccount special = new SpecialAccount(obj.getNumber(), obj.getBalance(), cc, client, obj.getActive());

		return repository.save(special);
	}

	public Optional<SpecialAccount> update(Integer id, SpecialDto obj) {
		Optional<SpecialAccount> OObjOrigin = repository.findById(id);
		if (OObjOrigin.isPresent()) {
			SpecialAccount objOrigin = OObjOrigin.get();
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

	public Optional<SpecialAccount> deactivate(Integer id, CurrentDto obj) {
		Optional<SpecialAccount> oObjOrigin = repository.findById(id);

		if (oObjOrigin.isPresent()) {
			SpecialAccount objOrigin = oObjOrigin.get();
			objOrigin.getCreditCard().setActive(obj.getActive());
			objOrigin.setActive(obj.getActive());
			return Optional.of(repository.save(objOrigin));
		}
		return Optional.empty();
	}

}