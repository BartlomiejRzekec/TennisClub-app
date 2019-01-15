package com.example.aspects;

import java.util.InputMismatchException;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Transactions {

	@Pointcut("execution(* com.example.repositories.ClientsRepository.findBy*(..))")
	public void ClientsPointcut() {
	}

	@Pointcut("execution(* com.example.repositories.TrainersRepository.findBy*(..))")
	public void TrainersPointcut() {
	}

	@AfterReturning(pointcut = "ClientsPointcut() && args(firstName, lastName)", returning = "returnedValue")
	public void findClient(String firstName, String lastName, Object returnedValue) {
		if (returnedValue == null) {
			System.out.println("Wrong data, try again");
		} else {
			System.out.println("Client " + firstName + " " + lastName + " found:");
		}
	}

	@Before("ClientsPointcut() && args(id)")
	public void findTrainer(long id) {
		System.out.println("Clients with trainer_id: " + id + " found:");
	}

	@AfterReturning(pointcut = "TrainersPointcut()", returning = "returnedValue")
	public void serveException(Object returnedValue) {
		if (returnedValue == null) {
			System.out.println("Wrong data!, try again");
		}
	}

}
