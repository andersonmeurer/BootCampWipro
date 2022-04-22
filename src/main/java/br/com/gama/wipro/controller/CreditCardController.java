package br.com.gama.wipro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.gama.wipro.entities.CreditCard;
import br.com.gama.wipro.entities.CurrentAccount;
import br.com.gama.wipro.services.CreditCardService;

@RequestMapping("creditcard")
@RestController
public class CreditCardController {

	private CreditCardService service;

	@Autowired
	public CreditCardController(CreditCardService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<CreditCard>> findAll(){
		List<CreditCard> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CreditCard> findById(@PathVariable Integer id) {
		CreditCard response = service.findById(id);
		return ResponseEntity.ok().body(response);
	}
	
	
	
//	@GetMapping("/{number}")
//	public ResponseEntity<List<CreditCard>> get(@RequestParam String number) {
//		Optional<List<CreditCard>> response = service.findByNumber(number);
//		if (response.isPresent()) {
//			return ResponseEntity.ok().body(response.get());
//		}
//		return ResponseEntity.notFound().build();
//	}

	@PostMapping
	public ResponseEntity<CreditCard> insert(@RequestBody CreditCard p) {
		service.insert(p);
		Optional<List<CreditCard>> retorno = service.findByNumber(p.getNumber());
		if (retorno.isPresent()) {
			return ResponseEntity.ok().body(retorno.get().get(0));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}