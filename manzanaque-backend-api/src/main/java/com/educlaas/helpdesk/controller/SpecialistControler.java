package com.educlaas.helpdesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educlaas.helpdesk.dao.Specialist;
import com.educlaas.helpdesk.service.SpecialistService;

@RestController
@RequestMapping(value = "/api")
public class SpecialistControler {
	
	@Autowired
	private SpecialistService spSrv;
	
	
	@GetMapping("/specialists")
	public List<Specialist> getAllScpecialists() {
		
		return spSrv.getAllScpecialists();
		
	}
}
