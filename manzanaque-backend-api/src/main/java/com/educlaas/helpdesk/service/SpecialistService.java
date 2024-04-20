package com.educlaas.helpdesk.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.helpdesk.dao.Caller;
import com.educlaas.helpdesk.dao.Specialist;
import com.educlaas.helpdesk.dao.Users;
import com.educlaas.helpdesk.repository.SpecialistRepository;

@Service
@Transactional
public class SpecialistService {
	
	@Autowired
	private SpecialistRepository specRepo;
	
	
	public List<Specialist> getAllScpecialists(){
		return specRepo.findAll();
	}	
	
	public Specialist saveSpecialist(Specialist specialist) {
        return specRepo.save(specialist);
    }
	
	public Specialist findByUserId(Users usersSp) {
		// TODO Auto-generated method stub
		        return specRepo.findByUserId(usersSp);
	}
	
	
	public Specialist findBySpecialistId(Long id) {
		// TODO Auto-generated method stub
		        return specRepo.findById(id).orElse(null);
	}
//	public Users findSpecialistByUserName(String userName) {
//        return usersRepo.findSpecialistByUserName(userName);
//    }
//	
//	public Users findOperatorByUserName(String userName) {
//        return usersRepo.findOperatorByUserName(userName);
//    }

	public List<Users[]> getAllScpecialistsByUsersId() {
		// TODO Auto-generated method stub
		return specRepo.getAllSpecialistsWithUsernames();
	}
}
