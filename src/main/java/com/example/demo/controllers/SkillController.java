package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.models.Skill;
import com.example.demo.services.SkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

	@Autowired
	private SkillService skillService;
	
	@PostMapping
	public Skill createSkill(@RequestBody Skill skill) {
		return skillService.createSkill(skill);
	}
	
	@GetMapping
	public List<Skill> getAllSkills(){
		return skillService.getAllSkills();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Skill> getSkillById(@PathVariable Long id) {
		Skill skill = skillService.getSkillById(id);
		return (skill != null) ? ResponseEntity.ok(skill) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public void deleteSkill(@PathVariable Long id) {
		skillService.deleteSkill(id);
	}
	
	@PutMapping("/{id}")
	public  ResponseEntity<Skill> updateSkill(@PathVariable Long id, @RequestBody Skill skillDetails){
		Skill skill = skillService.updateSkill(id, skillDetails);
		return (skill != null) ? ResponseEntity.ok(skill) : ResponseEntity.notFound().build();
	}
}
