package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Client;

public interface ClientsRepository extends JpaRepository<Client, Long>{

	 Client findByFirstNameAndLastName(String firstName, String lastName);
	 
	 List<Client> findByTrainerId(Long id);
	 
	 Client findByEmail(String email);
	 
	 
}
