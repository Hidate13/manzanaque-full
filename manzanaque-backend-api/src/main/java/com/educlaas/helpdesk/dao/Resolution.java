package com.educlaas.helpdesk.dao;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Resolution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resolutionID;


	private String resolutionDescription;
    private LocalDateTime resolutionTime;

//    @ManyToOne
//    @JoinColumn(name = "callID")
//    private Query que;
//
//    @ManyToOne
//    @JoinColumn(name = "specialistID")
//    private Specialist specialist;
//
//    @ManyToOne
//    @JoinColumn(name = "equipmentID")
//    private Equipment equipment;


    // Getters and setters
    public Long getResolutionID() {
    	return resolutionID;
    }
    
    public void setResolutionID(Long resolutionID) {
    	this.resolutionID = resolutionID;
    }
    
    public String getResolutionDescription() {
    	return resolutionDescription;
    }
    
    public void setResolutionDescription(String resolutionDescription) {
    	this.resolutionDescription = resolutionDescription;
    }
    
    public LocalDateTime getResolutionTime() {
    	return resolutionTime;
    }
    
    public void setResolutionTime(LocalDateTime resolutionTime) {
    	this.resolutionTime = resolutionTime;
    }
}
