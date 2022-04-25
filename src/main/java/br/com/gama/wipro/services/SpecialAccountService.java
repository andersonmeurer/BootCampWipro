package br.com.gama.wipro.services;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.gama.wipro.entities.CreditCard;
import br.com.gama.wipro.entities.SpecialAccount;
import br.com.gama.wipro.entities.dto.SpecialDto;
import br.com.gama.wipro.repositories.CreditCardRepository;
import br.com.gama.wipro.repositories.SpecialAccountRepository;
import br.com.gama.wipro.services.exceptions.DatabaseException;
import br.com.gama.wipro.services.exceptions.ResourceNotFoundException;

@Service
public class SpecialAccountService {

	private SpecialAccountRepository repository;
	private CreditCardRepository creditCardRepository;

	@Autowired
	public SpecialAccountService(SpecialAccountRepository repository, CreditCardRepository creditCardRepository) {
		this.repository = repository;
		this.creditCardRepository = creditCardRepository;
	}

	public List<SpecialAccount> findAll() {
		return repository.findAll();
	}

	public SpecialAccount findById(Integer id) {
		Optional<SpecialAccount> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public SpecialAccount create(SpecialDto obj) {

		CreditCard cc = new CreditCard(obj.getCreditCard().getBalance());
		creditCardRepository.save(cc);

		if (obj.getNumber() == null) {
			obj.setNumber(ThreadLocalRandom.current().nextInt(1000, 9999));
		}

		// próxima sprint
		// validar se numero da conta já existe

		SpecialAccount special = new SpecialAccount(obj.getNumber(), obj.getBalance(), cc);

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

	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

}