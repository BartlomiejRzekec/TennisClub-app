package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Size(min = 1, max = 15)
	private String firstName;
	@Size(min = 1, max = 15)
	private String lastName;
	@Column(name = "trainer_name")
	private String trainerByLastName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date_of_registration")
	private java.util.Date timeStamp;

	
	@ManyToOne
	@JoinColumn(name = "trainer_id")
	private Trainer trainer;

	@Override
	public String toString() {
		return "Clients [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", timeStamp=" + timeStamp
				+ ", trainers=" + trainer.toString() + "]";
	}

	public String getTrainerByLastName() {
		return trainerByLastName;
	}

	public void setTrainerByLastName(String trainerByLastName) {
		this.trainerByLastName = trainerByLastName;
	}

	
	public Trainer getTrainers() {
		return trainer;
	}

	public void setTrainers(Trainer trainers) {
		this.trainer = trainers;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public java.util.Date getTimeStamp() {
		return timeStamp;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setTimeStamp(java.util.Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
