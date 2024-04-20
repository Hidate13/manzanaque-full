package com.educlaas.helpdesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educlaas.helpdesk.dao.Software;
import com.educlaas.helpdesk.service.SoftwareService;

@RestController
@RequestMapping(value = "/api")
public class SoftwareController {

	    @Autowired
	    private SoftwareService softwareService;
	    
	  	//To View the stores
	  	@GetMapping("/softwares")
	  	public List<Software> getAllSoftwares() {
	  		//Get all the stores
	  		return softwareService.getAllSoftwares();
	  		
	  	}
}
