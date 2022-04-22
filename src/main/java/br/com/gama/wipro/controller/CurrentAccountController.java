package br.com.gama.wipro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gama.wipro.entities.CurrentAccount;
import br.com.gama.wipro.services.CurrentAccountService;

@RequestMapping("/current")
@RestController
public class CurrentAccountController {

	private CurrentAccountService service;

	@Autowired
	public CurrentAccountController(CurrentAccountService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<CurrentAccount>> findAll(){
		List<CurrentAccount> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{number}")
	public ResponseEntity<CurrentAccount> get(@RequestParam String number) {
		Optional<CurrentAccount> response = service.findByNumber(number);
		if (response.isPresent()) {
			return ResponseEntity.ok().body(response.get());
		}
		return ResponseEntity.notFound().build();
	}
}