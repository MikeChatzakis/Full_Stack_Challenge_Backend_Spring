package com.example.demo.dto.EmployeeSkillDTO;

import java.time.LocalDateTime;

public class EmployeeSkillWithSkillDTO extends EmployeeSkillBaseDTO {
	
	private Long skillId;
	private String skillName;
	private String skillDetails;
	
	public EmployeeSkillWithSkillDTO() {
	}

	public EmployeeSkillWithSkillDTO(Long id, LocalDateTime obtainedAt, Long skillId, String skillName, String skillDetails) {
		super(id, obtainedAt);
		this.skillId = skillId;
		this.skillName = skillName;
		this.skillDetails = skillDetails;
	}

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillDetails() {
		return skillDetails;
	}

	public void setSkillDetails(String skillDetails) {
		this.skillDetails = skillDetails;
	}
}
