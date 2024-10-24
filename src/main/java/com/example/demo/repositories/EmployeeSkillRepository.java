package com.example.demo.repositories;

import com.example.demo.dto.EmployeeSkillDTO.*;
import com.example.demo.models.EmployeeSkill;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;



import java.util.List;

@Repository
public interface EmployeeSkillRepository extends JpaRepository<EmployeeSkill, Long> {
	
	@Query("SELECT new com.example.demo.dto.EmployeeSkillDTO.EmployeeSkillWithSkillDTO(es.id, es.createdAt, es.skill.id, es.skill.name, es.skill.details) "
			+ "FROM EmployeeSkill es "
			+ "WHERE es.employee.id = :employeeId")	
	List<EmployeeSkillWithSkillDTO> findSkillsByEmployeeId(@Param("employeeId") Long employeeId);
	
	@Query("SELECT new com.example.demo.dto.EmployeeSkillDTO.EmployeeSkillWithEmployeeDTO(es.id, es.createdAt, es.employee.id, es.employee.firstName, es.employee.lastName) "
			+ "FROM EmployeeSkill es "
			+ "WHERE es.skill.id = :skillId")
	List<EmployeeSkillWithEmployeeDTO> findEmployeesBySkillId(@Param("skillId") Long skillId);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM EmployeeSkill es WHERE es.skill.id = :skillId")
	void EmployeeSkillDeleteBySkillId(@Param("skillId") Long Skillid);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM EmployeeSkill es WHERE es.employee.id = :employeeId")
	void EmployeeSkillDeleteByEmployeeId(@Param("employeeId") Long employeeId);
	
	@Modifying
	@Transactional
	@Query("DELETE FROM EmployeeSkill es WHERE es.employee.id = :employeeId AND es.skill.id = :skillId")
	void DeleteEmployeeSkill(@Param("employeeId") Long employeeId, @Param("skillId") Long skillId);
	
}