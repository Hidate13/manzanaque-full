package com.educlaas.helpdesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educlaas.helpdesk.dao.Problem;
import com.educlaas.helpdesk.service.ProblemService;

@RestController
@RequestMapping(value = "/api")
public class ProblemController {

	@Autowired
    private ProblemService problemService;
    
  	//To View the stores
  	@GetMapping("/problems")
  	public List<Problem> getAllProblems() {
  		//Get all the stores
  		return problemService.getAllProblems();
  		
  	}
}
