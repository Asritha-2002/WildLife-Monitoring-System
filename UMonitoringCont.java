package com.mahadev.login.controller;



import com.mahadev.login.model.UMonitoring;

import com.mahadev.login.service.UMonitoringSer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UMonitoringCont {

    private final UMonitoringSer uMonitoringSer;

    @Autowired
    public UMonitoringCont(UMonitoringSer uMonitoringSer) {
        this.uMonitoringSer = uMonitoringSer;
    }

   

    @PostMapping("/saveVideo")
    public String uploadVideo(@RequestParam("file") MultipartFile file,
    @RequestParam("image") MultipartFile image,
                              @RequestParam("uname") String uname,
                              @RequestParam("aname") String aname,
                              @RequestParam("description") String description,
                              @RequestParam("location") String location) {
        try {
            byte[] videoData = file.getBytes();
            byte[] imageData = image.getBytes();
            UMonitoring umonitoring = new UMonitoring();
            umonitoring.setrName(uname);
            umonitoring.setaName(aname);
            umonitoring.setDescription(description);
            umonitoring.setLocation(location);
            umonitoring.setVideo(videoData);
            umonitoring.setImage(imageData);
            uMonitoringSer.saveVideo(umonitoring);
            return "Video uploaded successfully!";
        } catch (IOException e) {
            return "Error uploading video: " + e.getMessage();
        }
    }

   

    @GetMapping("/videos")
    public List<UMonitoring> getAllVideos() {
        return uMonitoringSer.getAllVideos();
    }
}

