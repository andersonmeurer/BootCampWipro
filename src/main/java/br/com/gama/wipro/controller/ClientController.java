package br.com.gama.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gama.wipro.entities.Client;
import br.com.gama.wipro.entities.dto.ClientDto;
import br.com.gama.wipro.services.ClientService;

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
}
