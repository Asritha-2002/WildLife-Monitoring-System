package com.mahadev.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahadev.login.model.Researcher;

public interface ResearcherRepo extends JpaRepository<Researcher, Long>{
     Researcher findByEmail(String email);
}
