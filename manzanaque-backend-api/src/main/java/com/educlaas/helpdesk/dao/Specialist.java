package com.educlaas.helpdesk.dao;

import javax.persistence.*;

@Entity
public class Specialist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specialist_ID;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Users user_id;
	private String expertise;

    

    // Getters and setters
    public Long getSpecialistID() {
		return specialist_ID;
	}
	public void setSpecialistID(Long specialist_ID) {
		this.specialist_ID = specialist_ID;
	}
    public String getExpertise() {
    	return expertise;
    }
    public void setExpertise(String expertise) {
    	this.expertise = expertise;
    }
    public Users getUser_id() {
    	return user_id;
    }
    public void setUser_id(Users user_id) {
    	this.user_id = user_id;
    }
}
