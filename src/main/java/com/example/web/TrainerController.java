package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entities.Trainer;
import com.example.repositories.TrainersRepository;

@Controller
public class TrainerController {
	
	private TrainersRepository trainersRepository;

	@Autowired
	public TrainerController(TrainersRepository trainersRepository) {
		this.trainersRepository = trainersRepository;
	}

	@GetMapping("/addTrainers")
	public String addTrainers() {
		Trainer trainer1 = new Trainer();
		trainer1.setFirstName("Macej");
		trainer1.setLastName("Nowak");
		trainersRepository.save(trainer1);
		Trainer trainer2 = new Trainer();
		trainer2.setFirstName("Zbigniew");
		trainer2.setLastName("Kowalski");
		trainersRepository.save(trainer2);
		return "home";
	}
	
	@GetMapping("/addtrainer/{firstName}/{lastName}")
	public void addTrainer(@PathVariable String firstName,
						  @PathVariable String lastName) {
		Trainer trainer = new Trainer();
		trainer.setFirstName(firstName);
		trainer.setLastName(lastName);
		trainersRepository.save(trainer);
	}
	
	@GetMapping("/showAllTrainers")
	public @ResponseBody List<Trainer> findAllTrainers(){
		return trainersRepository.findAll();
	}
}
