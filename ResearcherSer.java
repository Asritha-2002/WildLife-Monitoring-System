package com.mahadev.login.service;
import java.util.List;
import com.mahadev.login.model.Researcher;
public interface ResearcherSer {
   Researcher findByEmail(String email);
    List<Researcher> getAllResearchers();
    void saveResearcher(Researcher researcher);
}

