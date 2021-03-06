package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entities.Client;
import com.example.repositories.ClientService;
import com.example.validator.UserRegisterValidator;

@Controller
public class ClientController {


	private ClientService clientService;
	
	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;

	}


	@GetMapping("/showAllClients")
	public @ResponseBody List<Client> findAllClients() {
		return clientService.findAllClients();
	}
	
	@GetMapping("/findClient")
	public String showFindClientForm(Client client) {
		return "findForm";
	}
	
	@PostMapping("/findClient")
	public @ResponseBody Client findClient(Client client, BindingResult result) {
		
		Client clientToFind = clientService.findByFirstNameAndLastName(client.getFirstName(), client.getLastName());
		
		return clientToFind;
	}
		
	
	@GetMapping("/register")
	public String showRegistrationForm(Client client) {
		return "registerForm";
	}
	
	@PostMapping("/register")
	public String processRegistration(Client client, BindingResult result) {
		
		
		Client clientExists = clientService.findClientByEmail(client.getEmail());
		
		 new UserRegisterValidator().validateEmailExist(clientExists, result);
		 
		 new UserRegisterValidator().validate(client, result);
		
		if(result.hasErrors()) {
			return "registerForm";
		}	
		else {
			
			
			clientService.saveClient(client);

			return "redirect:/client/" + client.getFirstName() + "/" + client.getLastName();
		}	
		
		
		
	}
	
	@GetMapping("/client/{firstName}/{lastName}")
	public String showLogingMessage(@PathVariable String firstName,
									 @PathVariable String lastName,
									 Model model) {
		Client client = clientService.findByFirstNameAndLastName(firstName, lastName);
		model.addAttribute(client);
		return "registerMessage";
	}
	

	@GetMapping("/profile")
	public String showClientProfile(Model model) {
		
		String email = null; 
				
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(!(auth instanceof AnonymousAuthenticationToken)) {
			email = auth.getName();
		}				
		
		Client client = clientService.findClientByEmail(email);
		
		long roleNumber = client.getRoles().stream()
												.findFirst()
												.get()
												.getId();
		
		client.setRoleNumber(roleNumber);
		model.addAttribute("client", client);
		
		return "profile";
		
	}
}
