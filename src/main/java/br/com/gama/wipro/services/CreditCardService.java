package br.com.gama.wipro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.gama.wipro.entities.CreditCard;
import br.com.gama.wipro.repositories.CreditCardRepository;

public class CreditCardService {

	private CreditCardRepository repository;

	@Autowired
	public CreditCardService(CreditCardRepository repository) {
		this.repository = repository;
	}

	public Optional<CreditCard> findById(Integer id) {
		return repository.findById(id);
	}

//	public List<CreditCard> findAll() {
//		return repository.findAll();
//	}

	public CreditCard insert(CreditCard p) {
		return repository.save(p);
	}

	public Optional<List<CreditCard>> findByNumber(String number) {
		return repository.findByNumber(number);
	}
}