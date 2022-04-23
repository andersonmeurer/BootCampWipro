package br.com.gama.wipro.services;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import br.com.gama.wipro.entities.CreditCard;
import br.com.gama.wipro.entities.CurrentAccount;
import br.com.gama.wipro.entities.dto.CurrentDto;
import br.com.gama.wipro.repositories.CreditCardRepository;
import br.com.gama.wipro.repositories.CurrentAccountRepository;
import br.com.gama.wipro.services.exceptions.DatabaseException;
import br.com.gama.wipro.services.exceptions.ResourceNotFoundException;

@Service
public class CurrentAccountService {

	private CurrentAccountRepository repository;
	private CreditCardRepository creditCardRepository;

	@Autowired
	public CurrentAccountService(CurrentAccountRepository repository, CreditCardRepository creditCardRepository) {
		this.repository = repository;
		this.creditCardRepository = creditCardRepository;
	}

	public List<CurrentAccount> findAll() {
		return repository.findAll();
	}

	public CurrentAccount findById(Integer id) {
		Optional<CurrentAccount> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public CurrentAccount create(CurrentDto obj) {

		CreditCard cc = new CreditCard(obj.getCreditCard().getBalance(), obj.getCreditCard().getNumber());
		creditCardRepository.save(cc);

		if (obj.getNumber() == null) {
			obj.setNumber(ThreadLocalRandom.current().nextInt(1000, 9999));
		}

		// próxima sprint
		// validar se numero da conta já existe

		CurrentAccount current = new CurrentAccount(obj.getNumber(), obj.getBalance(), cc);

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