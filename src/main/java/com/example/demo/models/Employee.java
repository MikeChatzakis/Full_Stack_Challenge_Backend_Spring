package com.example.demo.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private Long id;
	
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	@Column(updatable = false)
	private LocalDateTime updatedAt;
	
	@NotBlank(message = "Name cannot be empty")
	@Column(nullable = false)
	private String firstName;
	
	@NotBlank(message = "Last Name cannot be empty")
	@Column(nullable = false)
	private String lastName;
	
	@NotBlank(message = "Phone cannot be empty")
	@Column(nullable = false)
	private String phone;
	
	@NotBlank(message = "Email cannot be empty")
	@Email(message = "The format you entered doesn't correspont to an email")
	@Column(nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
	private Set<EmployeeSkill> employeeSkills;
	
	private LocalDateTime birthDate;
	private String street;
	private String city;
	private String state;
	private String postalCode;
	private String country;
	
	//Constructors
	public Employee() {
		this.employeeSkills = new HashSet<>();
	}

	public Employee(String firstName, String lastName, String phone, String email, LocalDateTime birthDate, String street, String city, String state, String postalCode, String country) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.birthDate = birthDate;
		this.street = street;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.employeeSkills = new HashSet<>();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
}
