package com.example.demo.repositories;

import com.example.demo.models.Skill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
	
}