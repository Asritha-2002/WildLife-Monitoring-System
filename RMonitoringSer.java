package com.mahadev.login.service;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.mahadev.login.model.RMonitoring;
import com.mahadev.login.repository.RMonitoringRepo;

@Service
public class RMonitoringSer {

    @Autowired
    private  RMonitoringRepo rMonitoringRepo;

    public String saveImage(MultipartFile file, String rname,String aname, String description) throws IOException {
        RMonitoring monitoring = new RMonitoring();
        monitoring.setrName(rname);
        monitoring.setaName(aname);
        monitoring.setDescription(description);
        monitoring.setImage(file.getBytes());

        rMonitoringRepo.save(monitoring);
        return "Image saved in DB";
    }

    public RMonitoring getImageById(Long id) {
        return rMonitoringRepo.findById(id).orElse(null);
    }

    public void saveImage(RMonitoring monitoring) {
        
        rMonitoringRepo.save(monitoring);
    }

   
    public List<RMonitoring> getAllImages() {
        return rMonitoringRepo.findAll();
    }
}

