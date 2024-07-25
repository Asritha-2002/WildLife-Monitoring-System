package com.mahadev.login.model;



import jakarta.persistence.*;

@Entity
public class UMonitoring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String uName;

    @Column
    private String aName;

    @Lob
    @Column(length = 2097152)
    private byte[] image;

    @Lob
    @Column(length = 16409616)
    private byte[] video;

    @Column
    private String description;

    @Column
    private String location;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getrName() {
        return uName;
    }

    public void setrName(String rName) {
        this.uName = rName;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public byte[] getVideo() {
        return video;
    }

    public void setVideo(byte[] video) {
        this.video = video;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
 
   }

   public String getLocation() {
    return location;
}

public void setLocation(String location) {
    this.location = location;
}
}

