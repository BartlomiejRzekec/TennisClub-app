package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entities.Trainer;
import com.example.repositories.TrainersRepository;

@Controller
public class HomeController {

	private TrainersRepository trainersRepository;

	@Autowired
	public HomeController(TrainersRepository trainersRepository) {
		this.trainersRepository = trainersRepository;
	}

	@GetMapping("/home")
	public String homePage() {
		
		return "home";
	}
	
	

}
