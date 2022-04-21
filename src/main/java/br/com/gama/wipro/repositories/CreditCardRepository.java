package br.com.gama.wipro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.gama.wipro.entities.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Integer>{

}
