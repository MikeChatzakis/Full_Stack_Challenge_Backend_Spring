package com.example.demo.controllers;

//import com.example.demo.models.Employee;
//import com.example.demo.models.Skill;

import com.example.demo.models.EmployeeSkill;
import com.example.demo.dto.EmployeeSkillDTO.*;
import com.example.demo.services.EmployeeSkillService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-skills")
public class EmployeeSkillController {
	
	@Autowired
	private EmployeeSkillService employeeSkillService;
	
	@PostMapping
	public EmployeeSkill createEmployeeSkill(@RequestBody EmployeeSkill relation) {
		return employeeSkillService.createEmployeeSkill(relation);
	}
	
	@PostMapping("/bulk")
	public List<EmployeeSkill> createEmployeeSkillBulk(@RequestBody List<EmployeeSkill> relations) {
		return employeeSkillService.createManyEmployeeSkill(relations);
	}
	
	@GetMapping
	public List<EmployeeSkill> findAllEmployeeSkills(){
		return employeeSkillService.getAllEmployeeSkills();
	}
	
	@GetMapping("/{id}")
	public  ResponseEntity<List<EmployeeSkillBaseDTO>> findSkillsWithEmployeeId(@PathVariable Long id){
		List<EmployeeSkillBaseDTO> employeeSkills = employeeSkillService.findSkillsWithEmployeeId(id);
		return (employeeSkills != null) ? ResponseEntity.ok(employeeSkills) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{employeeId}/{skillId}")
	public void deleteEmployeeSkill(@PathVariable Long employeeId, @PathVariable Long skillId) {
		employeeSkillService.deleteEmployeeSkill(employeeId, skillId);
	}
}
