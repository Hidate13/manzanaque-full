package com.educlaas.helpdesk.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.educlaas.helpdesk.dao.Operator;
import com.educlaas.helpdesk.dao.Specialist;

public class Register {
	
	@NotBlank(message = "Username is required")
	@Size(min = 8, max = 20, message = "Username length should be between 8 and 20 characters")
	private String userName;
	
	@Email
	@NotBlank(message = "Email is required")
	private String email; 
	
	@Size(min = 8, max = 20, message = "Username length should be between 8 and 20 characters")
	@NotBlank(message = "password is required")
	private String password;
	
	@NotBlank(message = "role is required")
	private String role;
	
	
	private Specialist specialist;
	
	private Operator operator;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Specialist getSpecialist() {
		return specialist;
	}
	public void setSpecialist(Specialist specialist) {
		this.specialist = specialist;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
}
