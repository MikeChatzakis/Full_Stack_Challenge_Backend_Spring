package com.example.demo.dto.EmployeeSkillDTO;

import java.time.LocalDateTime;

public class EmployeeSkillWithEmployeeDTO extends EmployeeSkillBaseDTO {
	
	private Long employeeId;
	private String employeeName;
	private String employeeLastName;
	
	public EmployeeSkillWithEmployeeDTO() {
	}

	public EmployeeSkillWithEmployeeDTO(Long id, LocalDateTime obtainedAt, Long employeeId, String employeeName, String employeeLastName) {
		super(id, obtainedAt);
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeLastName = employeeLastName;
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeSurname() {
		return employeeLastName;
	}
	public void setEmployeeSurname(String employeeSurname) {
		this.employeeLastName = employeeSurname;
	}
}
