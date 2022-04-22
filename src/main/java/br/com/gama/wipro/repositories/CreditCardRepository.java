package br.com.gama.wipro.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gama.wipro.entities.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {

	Optional<List<CreditCard>> findByNumber(String number);

}
