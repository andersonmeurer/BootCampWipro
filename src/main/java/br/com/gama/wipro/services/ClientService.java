package br.com.gama.wipro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gama.wipro.entities.Client;
import br.com.gama.wipro.entities.dto.ClientDto;
import br.com.gama.wipro.entities.dto.SpecialDto;
import br.com.gama.wipro.repositories.ClientRepository;

@Service
public class ClientService {

	private ClientRepository repository;
//	private CurrentAccountService currentService;
	private SpecialAccountService specialService;

	@Autowired
	public ClientService(ClientRepository repository) {
		this.repository = repository;
//		this.currentService = currentService;
//		this.specialService = specialService;
	}

	public Client create(ClientDto obj) {
		Client client = new Client(obj.getName());
		client = repository.save(client);

//		SpecialDto special = new SpecialDto();
//		special.setClient(client);
//		specialService.create(special);
		return client;
	}

	public List<Client> findAll() {
		return repository.findAll();
	}

	public Optional<Client> update(Integer id, ClientDto obj) {
		Optional<Client> OObjOrigin = repository.findById(id);
		if (OObjOrigin.isPresent()) {
			String name = obj.getName();
			Client objOrigin = OObjOrigin.get();
			
			objOrigin.setName(name);
					
			return Optional.of(repository.save(objOrigin));
		}
		return Optional.empty();
	}
	
	
}