package br.com.gama.wipro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gama.wipro.entities.CreditCard;
import br.com.gama.wipro.repositories.CreditCardRepository;

@Service
public class CurrentAccountService {
	private CreditCardRepository repository;
	
	@Autowired
	public void CreditCardService(CreditCardRepository repository) {
		this.repository = repository;
	}
	
	public Optional<CreditCard> get(Integer id) {
		return repository.findById(id);
	}
	
	public List<CreditCard> findAll(){
		return repository.findAll();
	}
}
