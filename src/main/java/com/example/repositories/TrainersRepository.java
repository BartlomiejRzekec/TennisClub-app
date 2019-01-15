package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Trainer;

public interface TrainersRepository extends JpaRepository<Trainer, Long>{

	
	Trainer findByLastName(String lastName);
}
