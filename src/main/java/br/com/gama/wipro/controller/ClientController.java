package br.com.gama.wipro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.gama.wipro.entities.Client;
import br.com.gama.wipro.entities.CurrentAccount;
import br.com.gama.wipro.entities.SpecialAccount;
import br.com.gama.wipro.entities.dto.ClientDto;
import br.com.gama.wipro.entities.dto.CurrentDto;
import br.com.gama.wipro.services.ClientService;
import br.com.gama.wipro.services.exceptions.ResourceNotFoundException;

@RequestMapping("/client")
@RestController
public class ClientController {
	private ClientService service;
	
	@Autowired
	public ClientController(ClientService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<Client> insert(@RequestBody ClientDto obj) {
		Client newObj = service.create(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(newObj);
	}
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		List<Client> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PutMapping("/{id}")
	public Client update(@PathVariable Integer id, @RequestBody ClientDto obj) {
		Optional<Client> response = service.update(id, obj);
		return response.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	@DeleteMapping("/{id}")
	public Client deactivate(@PathVariable Integer id, @RequestBody ClientDto obj) {
		Optional<Client> response = service.deactivate(id, obj);
		return response.orElseThrow(()-> new ResourceNotFoundException(id));		
	}
	
}
