package br.com.gama.wipro.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gama.wipro.entities.SpecialAccount;
import br.com.gama.wipro.services.SpecialAccountService;

@RequestMapping("/special")
@RestController
public class SpecialAccountController {

	private SpecialAccountService service;

	@Autowired
	public SpecialAccountController(SpecialAccountService service) {
		this.service = service;
	}

	@GetMapping("/{number}")
	public ResponseEntity<SpecialAccount> get(@RequestParam String number) {
		Optional<SpecialAccount> response = service.findByNumber(number);
		if (response.isPresent()) {
			return ResponseEntity.ok().body(response.get());
		}
		return ResponseEntity.notFound().build();
	}
}