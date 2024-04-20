package com.educlaas.helpdesk.dao;

import javax.persistence.*;

@Entity
public class Software {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long softwareID;

	private String softwareName;
	
//  private boolean isValidLicense;
     
    private String serialNumber;
    

//	@ManyToOne
//    @JoinColumn(name = "callerid")
//    private Caller callerid;
    


	// Getters and setters
    public Long getSoftwareID() {
    	return softwareID;
    }
    
    public void setSoftwareID(Long softwareID) {
    	this.softwareID = softwareID;
    }
    
    public String getSoftwareName() {
    	return softwareName;
    }
    
    public void setSoftwareName(String softwareName) {
    	this.softwareName = softwareName;
    }
    
//    public boolean getIsValidLicense() {
//    	return isValidLicense;
//    }
//    
//    public void setIsValidLicense(boolean isValidLicense) {
//    	this.isValidLicense = isValidLicense;
//    }
    
    public String getSerialNumber() {
    	return serialNumber;
    }
    
    public void setSerialNumber(String serialNumber) {
    	this.serialNumber = serialNumber;
    }
    
//    public Caller getCallerid() {
//    	return callerid;
//    }
//    
//    public void setCallerid(Caller callerid) {
//    	this.callerid = callerid;
//    }
}
