package com.educlaas.helpdesk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.helpdesk.dao.Problem;
import com.educlaas.helpdesk.repository.ProblemRepository;

@Service
@Transactional
public class ProblemService {

	@Autowired
	private ProblemRepository problemRepo;
	
	public List<Problem> getAllProblems(){
		return problemRepo.findAll();
	}
	
	public Problem saveProblem(Problem problem) {
		return problemRepo.save(problem);
	}
}
