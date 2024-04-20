package com.educlaas.helpdesk.dao;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long problemID;


	private String problemType;
    private String problemDescription;
//    private LocalDateTime dateResolved;
//    private String resolutionDetails;
//    private Long resolutionTimeInMinutes;

   

    //getters and setters
    public Long getProblemID() {
    	return problemID;
    }
    
    public void setProblemID(Long problemID) {
    	this.problemID = problemID;
    }
    
    public String getProblemType() {
    	return problemType;
    }
    
    public void setProblemType(String problemType) {
    	this.problemType = problemType;
    }
    
    public String getProblemDescription() {
    	return problemDescription;
    }
    
    public void setProblemDescription(String problemDescription) {
    	this.problemDescription = problemDescription;
    }
    
//    public LocalDateTime getDateResolved() {
//    	return dateResolved;
//    }
//    
//    public void setDateResolved(LocalDateTime dateResolved) {
//    	this.dateResolved = dateResolved;
//    }
//    
//    public String getResolutionDetails() {
//    	return resolutionDetails;
//    }
//    
//    public void setResolutionDetails(String resolutionDetails) {
//    	this.resolutionDetails = resolutionDetails;
//    }
//    
//    public Long getResolutionTimeInMinutes() {
//    	return resolutionTimeInMinutes;
//    }
//    
//    public void setResolutionTimeInMinutes(Long resolutionTimeInMinutes) {
//    	this.resolutionTimeInMinutes = resolutionTimeInMinutes;
//    }
}
