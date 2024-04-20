package com.educlaas.helpdesk.dao;

import javax.persistence.*;

import org.apache.catalina.User;

@Entity
public class Operator {
	   	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long operator_ID;
	   
	   	@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "user_id")
	   	private Users user_id ;



		// Getters and setters
	   	public Users getUser_id() {
	   		return user_id;
	   	}
	   	
	   	public void setUser_id(Users users) {
	   		this.user_id = users;
	   	}
		public Long getOperatorID() {
			return operator_ID;
		}

		public void setOperatorID(Long operator_ID) {
			this.operator_ID = operator_ID;
		}
//		public String getOperatorName() {
//			return operatorName;
//		}
//		
//		public void setOperatorName(String operatorName) {
//			this.operatorName = operatorName;
//		}


}
