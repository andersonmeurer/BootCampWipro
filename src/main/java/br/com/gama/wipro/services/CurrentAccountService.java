package br.com.gama.wipro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gama.wipro.entities.CurrentAccount;
import br.com.gama.wipro.repositories.CurrentAccountRepository;

@Service
public class CurrentAccountService {

	private CurrentAccountRepository repository;
	
	@Autowired
	public CurrentAccountService(CurrentAccountRepository repository) {
		this.repository = repository;
	}
	
//	public Optional<CurrentAccount> get(Integer id) {
//		return repository.findById(id);
//	}
//	
	public List<CurrentAccount> findAll(){
		return repository.findAll();
	}

	public Optional<CurrentAccount> findByNumber(String number) {
		return repository.findByNumber(number);
	}

}