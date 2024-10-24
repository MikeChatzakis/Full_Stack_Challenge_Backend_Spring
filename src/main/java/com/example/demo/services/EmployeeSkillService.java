package com.example.demo.services;

import com.example.demo.models.EmployeeSkill;
import com.example.demo.dto.EmployeeSkillDTO.*;
import com.example.demo.repositories.EmployeeSkillRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class EmployeeSkillService {

	@Autowired
	EmployeeSkillRepository employeeSkillRepository;
	
	public EmployeeSkill createEmployeeSkill(EmployeeSkill employeeSkill) {
		return employeeSkillRepository.save(employeeSkill);
	}
	
	@Transactional
	public List<EmployeeSkill> createManyEmployeeSkill(List<EmployeeSkill> employeeSkills){
		return employeeSkillRepository.saveAll(employeeSkills);
	}
	
	public List<EmployeeSkillBaseDTO> findSkillsWithEmployeeId (Long employeeId){
	    List<EmployeeSkillWithSkillDTO> skillDTOs = employeeSkillRepository.findSkillsByEmployeeId(employeeId);
	    return new ArrayList<EmployeeSkillBaseDTO>(skillDTOs);
	}
	
	@Transactional
	public void deleteEmployeeSkillWithSkillId(Long skillId){
		employeeSkillRepository.EmployeeSkillDeleteBySkillId(skillId);
	}
	
	@Transactional
	public void deleteEmployeeSkillWithEmployeeId(Long employeeId){
		employeeSkillRepository.EmployeeSkillDeleteByEmployeeId(employeeId);
	}
	
	@Transactional
	public void deleteEmployeeSkill(Long employeeId, Long skillId){
		employeeSkillRepository.DeleteEmployeeSkill(employeeId, skillId);
	}

	public List<EmployeeSkill> getAllEmployeeSkills (){
		return employeeSkillRepository.findAll();
	}
	
}
