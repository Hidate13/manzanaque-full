package com.educlaas.helpdesk.dao;


import java.util.List;

import javax.persistence.*;

@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipmentID;


	private String equipmentType;
    private String equipmentMake;
    
    

	// Getters and setters
    public Long getEquipmentID() {
  		return equipmentID;
  	}

  	public void setEquipmentID(Long equipmentID) {
  		this.equipmentID = equipmentID;
  	}
  	
    public String getEquipmentType() {
    	return equipmentType;
    }
    
    public void setEquipmentType(String equipmentType) {
    	this.equipmentType = equipmentType;
    }
    
    public String getEquipmentMake() {
    	return equipmentMake;
    }
    
    public void setEquipmentMake(String equipmentMake) {
    	this.equipmentMake = equipmentMake;
    }



}
