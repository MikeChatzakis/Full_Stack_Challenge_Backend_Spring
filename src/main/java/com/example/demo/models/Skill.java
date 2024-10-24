package com.example.demo.models;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Skill {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    private Long id;
	
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	@Column(updatable = false)
	private LocalDateTime updatedAt;
	
	@NotBlank(message = "Please enther a name for the Skill")
	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "skill", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
	private Set<EmployeeSkill> employeeSkills;
	
	private String details;
	
	//Constructors
	public Skill() {
		this.employeeSkills = new HashSet<>();
	}
	
	public Skill(String name, String details) {
		this.name = name;
		this.details = details;
		this.employeeSkills = new HashSet<>();
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

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
