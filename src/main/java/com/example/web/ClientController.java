package com.example.web;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entities.Client;
import com.example.entities.Trainer;
import com.example.repositories.ClientsRepository;
import com.example.repositories.TrainersRepository;

@Controller
public class ClientController {

	private ClientsRepository clientsRepository;
	private TrainersRepository trainersRepository; 

	@Autowired
	public ClientController(ClientsRepository clientsRepository, TrainersRepository trainersRepository) {
		this.clientsRepository = clientsRepository;
		this.trainersRepository = trainersRepository;
	}

	@GetMapping("/showAllClients")
	public @ResponseBody List<Client> findAllClients() {
		return clientsRepository.findAll();
	}

		
	
	@GetMapping("/register")
	public String showRegistrationForm(Client client) {
		return "registerForm";
	}
	
	@PostMapping("/register")
	public String processRegistration(Trainer trainer, @Valid Client client, Errors errors) {
		if(errors.hasErrors()) {
			return "registerForm";
		}		
		Trainer trainerByLastName = trainersRepository.findByLastName(client.getTrainerByLastName());
		client.setTrainers(trainerByLastName);
		client.setTimeStamp(new Date());
		clientsRepository.save(client);
		return "redirect:/client/" + client.getFirstName() + "&" + client.getLastName();
	}
	
	@GetMapping("/client/{firstName}&{lastName}")
	public String showClientsProfile(@PathVariable String firstName,
									 @PathVariable String lastName,
									 Model model) {
		Client client = clientsRepository.findByFirstNameAndLastName(firstName, lastName);
		model.addAttribute(client);
		return "profile";
	}
	
	@GetMapping("/findClient")
	public String showFindingForm(Client client) {
		return "findForm";
	}
	
	@PostMapping("/findClient")
	public @ResponseBody Client processFinding(Client client) {
		Client clientToFind = clientsRepository.findByFirstNameAndLastName(client.getFirstName(), client.getLastName());
		return clientToFind;
	}
}
