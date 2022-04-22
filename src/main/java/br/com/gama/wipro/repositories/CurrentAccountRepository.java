package br.com.gama.wipro.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gama.wipro.entities.CurrentAccount;

public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Integer>{

	Optional<CurrentAccount> findByNumber(String number);

}