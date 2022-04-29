package br.com.gama.wipro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gama.wipro.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
