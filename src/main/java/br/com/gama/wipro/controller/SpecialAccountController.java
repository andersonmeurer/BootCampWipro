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

import br.com.gama.wipro.entities.SpecialAccount;
import br.com.gama.wipro.entities.SpecialAccount;
import br.com.gama.wipro.entities.dto.CurrentDto;
import br.com.gama.wipro.entities.dto.SpecialDto;
import br.com.gama.wipro.services.SpecialAccountService;
import br.com.gama.wipro.services.exceptions.ResourceNotFoundException;

@RequestMapping("/special")
@RestController
public class SpecialAccountController {

	private SpecialAccountService service;

	@Autowired
	public SpecialAccountController(SpecialAccountService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<SpecialAccount>> findAll() {
		List<SpecialAccount> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<SpecialAccount> findById(@PathVariable Integer id) {
		SpecialAccount response = service.findById(id);
		return ResponseEntity.ok().body(response);
	}

	@PostMapping
	public ResponseEntity<SpecialAccount> insert(@RequestBody SpecialDto obj) {
		SpecialAccount newObj = service.create(obj);
		return ResponseEntity.status(HttpStatus.CREATED).body(newObj);
	}

	@PutMapping("/{id}")
	public SpecialAccount update(@PathVariable Integer id, @RequestBody SpecialDto obj) {
		Optional<SpecialAccount> response = service.update(id, obj);
		return response.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	@DeleteMapping("/{id}")
	public SpecialAccount deactivate(@PathVariable Integer id, @RequestBody CurrentDto obj) {
		Optional<SpecialAccount> response = service.deactivate(id, obj);
		return response.orElseThrow(()-> new ResourceNotFoundException(id));		
	}
}