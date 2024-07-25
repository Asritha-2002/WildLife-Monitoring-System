package com.mahadev.login.service;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.mahadev.login.model.UMonitoring;

import com.mahadev.login.repository.UMonitoringRepo;

@Service
public class UMonitoringSer {

    @Autowired
    private UMonitoringRepo uMonitoringRepo;

   

    public String saveVideo(MultipartFile file, MultipartFile image, String uname, String aname, String description, String location) throws IOException {
        UMonitoring monitoring = new UMonitoring();
        monitoring.setrName(uname);
        monitoring.setaName(aname);
        monitoring.setDescription(description);
        monitoring.setLocation(location);
        monitoring.setVideo(file.getBytes());
        monitoring.setImage(image.getBytes());

        uMonitoringRepo.save(monitoring);
        return "Video saved in DB";
    }

  

    public UMonitoring getVideoById(Long id) {
        return uMonitoringRepo.findById(id).orElse(null);
    }

  
    public void saveVideo(UMonitoring monitoring) {
        uMonitoringRepo.save(monitoring);
    }

  

    public List<UMonitoring> getAllVideos() {
        return uMonitoringRepo.findAll();
    }
}

