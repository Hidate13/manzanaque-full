package com.educlaas.helpdesk.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.helpdesk.dao.Operator;
import com.educlaas.helpdesk.dao.Users;
import com.educlaas.helpdesk.repository.OperatorRepository;

@Service
@Transactional
public class OperatorService {

	@Autowired 
	private OperatorRepository opRepo;
	

	public Operator findByUserId(Users users) {
		// TODO Auto-generated method stub
		        return opRepo.findByUserId(users);
	}


	public Operator saveOperator(Operator tmpOp) {
		// TODO Auto-generated method stub
		return opRepo.save(tmpOp);
	}
	
}
