package br.com.gama.wipro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gama.wipro.entities.Client;
import br.com.gama.wipro.entities.CurrentAccount;
import br.com.gama.wipro.entities.dto.ClientDto;
import br.com.gama.wipro.entities.dto.SpecialDto;
import br.com.gama.wipro.repositories.ClientRepository;
import br.com.gama.wipro.repositories.CreditCardRepository;
import br.com.gama.wipro.repositories.CurrentAccountRepository;

@Service
public class ClientService {

	private ClientRepository repository;
	private CurrentAccountService currentService;
	private SpecialAccountService specialService;

	@Autowired
	public ClientService(
			ClientRepository repository, 
			CurrentAccountService currentService, 
			SpecialAccountService specialService) {
		this.repository = repository;
		this.currentService = currentService;
		this.specialService = specialService;
	}
	
	public Client create(ClientDto obj) {
		Client client= new Client(obj.getName());
		SpecialDto special = new SpecialDto();
		client = repository.save(client);
		specialService.create(special);
		return client;
	}
	
	
}
