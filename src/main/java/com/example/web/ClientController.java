package com.example.web;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entities.Client;
import com.example.entities.Trainer;
import com.example.repositories.ClientService;
import com.example.repositories.ClientsRepository;
import com.example.repositories.RoleRepository;
import com.example.repositories.TrainersRepository;
import com.example.validator.UserRegisterValidator;

@Controller
public class ClientController {

	private ClientsRepository clientsRepository;
	private TrainersRepository trainersRepository; 
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private ClientService clientService;
	private MessageSource messageSource;
	
	@Autowired
	public ClientController(ClientsRepository clientsRepository, TrainersRepository trainersRepository,
			RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ClientService clientService,
			MessageSource messageSource) {
		super();
		this.clientsRepository = clientsRepository;
		this.trainersRepository = trainersRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.clientService = clientService;
		this.messageSource = messageSource;
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
	public String processRegistration( Client client, BindingResult result, Model model, Locale locale) {
		
		
		Client clientExists = clientService.findClientByEmail(client.getEmail());
		
		 new UserRegisterValidator().validateEmailExist(clientExists, result);
		 
		 new UserRegisterValidator().validate(client, result);
		
		if(result.hasErrors()) {
			return "registerForm";
		}	
		else {
			
			
			
			clientService.saveClient(client);
			
			model.addAttribute("message", messageSource.getMessage("user.register.success.email", null, locale));
			//model.addAttribute("user", new User());
			return "redirect:/client/" + client.getFirstName() + "/" + client.getLastName();
		}	
		
		
		
	}
	
	@GetMapping("/client/{firstName}/{lastName}")
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
