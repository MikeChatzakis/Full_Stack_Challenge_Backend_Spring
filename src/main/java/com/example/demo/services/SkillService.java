package com.example.demo.services;

import com.example.demo.models.Skill;
import com.example.demo.repositories.SkillRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

	@Autowired
	private SkillRepository skillRepository;
	
	public Skill createSkill(Skill skill) {
		return skillRepository.save(skill);
	}
	
	public List<Skill> getAllSkills(){
		return skillRepository.findAll();
	}
	
	public Skill getSkillById(Long id) {
		return skillRepository.findById(id).orElse(null);
	}
	
	public void deleteSkill(Long id) {
		skillRepository.deleteById(id);
	}
	
	public Skill updateSkill(Long id, Skill skillDetails) {
		skillDetails.setId(id);
		return skillRepository.save(skillDetails);
	}
}
