package com.example.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int enabled;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "client_role", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;

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

	@Transient
	private long roleNumber;

	
	
	
	
	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public long getRoleNumber() {
		return roleNumber;
	}

	public void setRoleNumber(long roleNumber) {
		this.roleNumber = roleNumber;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getTrainerByLastName() {
		return trainerByLastName;
	}

	public void setTrainerByLastName(String trainerByLastName) {
		this.trainerByLastName = trainerByLastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public java.util.Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(java.util.Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
