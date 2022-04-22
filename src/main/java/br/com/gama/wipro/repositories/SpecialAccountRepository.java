package br.com.gama.wipro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gama.wipro.entities.SpecialAccount;

public interface SpecialAccountRepository extends JpaRepository<SpecialAccount, Integer> {

}
