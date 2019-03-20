package com.example.repositories;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Client;

@Service
@Transactional
public interface ClientService {
	
	public Client saveClient(Client client);
	public Client findClientByEmail(String email);
	public Client findByFirstNameAndLastName(String firstName, String lastName);
	public List<Client> findAllClients();

}
