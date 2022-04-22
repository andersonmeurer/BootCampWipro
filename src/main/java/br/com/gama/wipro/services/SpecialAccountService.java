package br.com.gama.wipro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gama.wipro.entities.CurrentAccount;
import br.com.gama.wipro.entities.SpecialAccount;
import br.com.gama.wipro.repositories.SpecialAccountRepository;

@Service
public class SpecialAccountService {

	private SpecialAccountRepository repository;

	@Autowired
	public SpecialAccountService(SpecialAccountRepository repository) {
		this.repository = repository;
	}

//	public Optional<SpecialAccount> get(Integer id) {
//		return repository.findById(id);
//	}
//
//	public List<SpecialAccount> findAll() {
//		return repository.findAll();
//	}
	
	public Optional<SpecialAccount> findByNumber(String number) {
		return repository.findByNumber(number);
	}
}