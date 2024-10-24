package com.example.demo.dto.EmployeeSkillDTO;

import java.time.LocalDateTime;

public class EmployeeSkillBaseDTO {
	
	private Long id;
	private LocalDateTime obtainedAt;
	
	public EmployeeSkillBaseDTO() {
	}

	public EmployeeSkillBaseDTO(Long id, LocalDateTime obtainedAt) {
		this.id = id;
		this.obtainedAt = obtainedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getObtainedAt() {
		return obtainedAt;
	}

	public void setObtainedAt(LocalDateTime obtainedAt) {
		this.obtainedAt = obtainedAt;
	}
}
