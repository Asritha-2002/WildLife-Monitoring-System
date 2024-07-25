package com.mahadev.login.controller;


import com.mahadev.login.model.RMonitoring;
import com.mahadev.login.service.RMonitoringSer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RMonitoringCont {

    private final RMonitoringSer rMonitoringSer;

    @Autowired
    public RMonitoringCont(RMonitoringSer rMonitoringSer) {
        this.rMonitoringSer = rMonitoringSer;
    }

    @PostMapping("/save")
    public String uploadMonitoring(@RequestParam("file") MultipartFile file,
                              @RequestParam("rname") String rname,
                              @RequestParam("aname") String aname,
                              @RequestParam("description") String description) {
        try {
            byte[] imageData = file.getBytes();
            RMonitoring rmonitoring = new RMonitoring();
            rmonitoring.setrName(rname);
            rmonitoring.setaName(aname);
            rmonitoring.setDescription(description);
            rmonitoring.setImage(imageData);
            rMonitoringSer.saveImage(rmonitoring);
            return "File uploaded successfully!";
        } catch (IOException e) {
            return "Error uploading file: " + e.getMessage();
        }
    } 
    @GetMapping("/images")
    public List<RMonitoring> getAllImages() {
        return rMonitoringSer.getAllImages();
    }
}


