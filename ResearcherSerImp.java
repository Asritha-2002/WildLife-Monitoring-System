package com.mahadev.login.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahadev.login.model.Researcher;
import com.mahadev.login.repository.ResearcherRepo;

@Service
public class ResearcherSerImp implements ResearcherSer{
    @Autowired
    private ResearcherRepo userRepository;

    @Override
    public Researcher findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<Researcher> getAllResearchers() {
        return userRepository.findAll();
    }

    @Override
    public void saveResearcher(Researcher researcher) {
        userRepository.save(researcher);
    }
}







