package com.example.repositories;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Client;
import com.example.entities.Role;
import com.example.entities.Trainer;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{

	
	private ClientsRepository clientsRepository;
	private TrainersRepository trainersRepository; 
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public ClientServiceImpl(ClientsRepository clientsRepository, TrainersRepository trainersRepository,
			RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.clientsRepository = clientsRepository;
		this.trainersRepository = trainersRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@Override
	public Client saveClient(Client client) {
		
		
		client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
		
		
		Role role = roleRepository.findByRole("ROLE_ADMIN");
		client.setRoles(new HashSet<Role>(Arrays.asList(role)));
		
		Trainer trainerByLastName = trainersRepository.findByLastName(client.getTrainerByLastName());
		client.setTrainers(trainerByLastName);
		client.setTimeStamp(new Date());
		client.setEnabled(1);
		clientsRepository.save(client);
		
		return null;
	}

	@Override
	public Client findClientByEmail(String email) {
		
		Client client = clientsRepository.findByEmail(email);
		
		return client;
	}

	
	
	
	
}
