package br.com.gama.wipro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gama.wipro.entities.CurrentAccount;

public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Long>{

}
