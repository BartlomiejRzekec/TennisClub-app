package com.example.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.repositories.TrainersRepository;

@Controller
public class HomeController {

	private TrainersRepository trainersRepository;

	@Autowired
	public HomeController(TrainersRepository trainersRepository) {
		this.trainersRepository = trainersRepository;
	}

	@GetMapping({"/home", "/"})
	public String homePage() {
		return "home";
	}
	
	

}
