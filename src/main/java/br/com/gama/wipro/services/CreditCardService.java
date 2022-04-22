package br.com.gama.wipro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gama.wipro.entities.CreditCard;
import br.com.gama.wipro.entities.CurrentAccount;
import br.com.gama.wipro.repositories.CreditCardRepository;
import br.com.gama.wipro.services.exceptions.ResourceNotFoundException;

@Service
public class CreditCardService {

	private CreditCardRepository repository;

	@Autowired
	public CreditCardService(CreditCardRepository repository) {
		this.repository = repository;
	}

	public CreditCard findById(Integer id) {
		Optional<CreditCard> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}

	public List<CreditCard> findAll() {
		return repository.findAll();
	}

	public CreditCard insert(CreditCard p) {
		return repository.save(p);
	}

	public Optional<List<CreditCard>> findByNumber(String number) {
		return repository.findByNumber(number);
	}
}