package br.com.gama.wipro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gama.wipro.entities.CurrentAccount;
import br.com.gama.wipro.repositories.CurrentAccountRepository;
import br.com.gama.wipro.services.exceptions.ResourceNotFoundException;

@Service
public class CurrentAccountService {

	@Autowired
	private CurrentAccountRepository repository;
	
	
//	public CurrentAccountService(CurrentAccountRepository repository) {
//		this.repository = repository;
//	}
	
//	public Optional<CurrentAccount> get(Integer id) {
//		return repository.findById(id);
//	}
//	
	public List<CurrentAccount> findAll(){
		return repository.findAll();
	}

	public CurrentAccount findById (Integer id) {
		Optional<CurrentAccount> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));

	}

	public CurrentAccount create(CurrentAccount obj) {
		return repository.save(obj);
	}
}