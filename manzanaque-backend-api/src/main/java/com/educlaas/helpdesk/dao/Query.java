package com.educlaas.helpdesk.dao;

import java.time.LocalDateTime;

import javax.persistence.*;


@Entity
public class Query {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long callID;


		private LocalDateTime callTime;

	    @ManyToOne
	    @JoinColumn(name = "caller")
	    private Caller caller;
	    
//	    @ManyToOne
//	    @JoinColumn(name = "users")
//	    private Users users;

	    @ManyToOne
	    @JoinColumn(name = "equipment")
	    private Equipment equipment;
	    
	    @ManyToOne
	    @JoinColumn(name = "problem")
	    private Problem problem;
	    
	    @ManyToOne
	    @JoinColumn(name = "software")
	    private Software software;

	    @ManyToOne
	    @JoinColumn(name = "resolution")
	    private Resolution resolution;
	    
	    @ManyToOne
	    @JoinColumn(name = "specialist")
	    private Specialist specialist;
	    
	    @ManyToOne
	    @JoinColumn(name = "operator")
	    private Operator operator;


		
		


		// Getters and setters
	    public Long getCallID() {
			return callID;
		}

		public void setCallID(Long callID) {
			this.callID = callID;
		}
		
//	    public Users getUsers() {
//	    	return users;
//	    }
//	    
//	    public void setUsers(Users users) {
//	    	this.users = users;
//	    }
	    
	    public Caller getCaller() {
	    	return caller;
	    }
	    
	    public void setCaller(Caller caller) {
	    	this.caller = caller;
	    }
	    
	    public Equipment getEquipment() {
	    	return equipment;
	    }
	    
	    public void setEquipment(Equipment equipment) {
	    	this.equipment = equipment;
	    }
	    
	    public Problem getProblem() {
	    	return problem;
	    }
	    
	    public void setProblem(Problem problem) {
	    	this.problem = problem;
	    }
	    
	    public LocalDateTime getCallTime() {
	    	return callTime;
	    }
	    
	    public void setCallTime(LocalDateTime callTime) {
	    	this.callTime = callTime;
	    }
	    
	    public Software getSoftware() {
			return software;
		}

		public void setSoftware(Software software) {
			this.software = software;
		}
		

		public Resolution getResolution() {
			return resolution;
		}

		public void setResolution(Resolution resolution) {
			this.resolution = resolution;
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
