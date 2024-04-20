package com.educlaas.helpdesk.dao;


import javax.persistence.*;

//Caller.java
@Entity
@Table(name = "caller")
public class Caller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long callerID;

	
	private String jobTitle;
	private String department;
	private String callerName;
	
//	@ManyToOne
//    @JoinColumn(name = "equipmentID")
//    private Equipment equipment;
//	
//
//	@ManyToOne
//    @JoinColumn(name = "softwareID")
//    private Software software;

	// Getters and setters
	public Long getCallerID() {
		return callerID;
	}

	public void setCallerID(Long callerID) {
		this.callerID = callerID;
	}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getCallerName() {
		return callerName;
	}

	public void setCallerName(String callerName) {
		this.callerName = callerName;
	}
	
//	public Equipment getEquipment() {
//		return equipment;
//	}
//	
//	public void setEquipment(Equipment equipment) {
//		this.equipment = equipment;
//	}
//	
//	public Software getSoftware() {
//		return software;
//	}
//	
//	public void setSoftware(Software software) {
//		this.software = software;
//	}
}
