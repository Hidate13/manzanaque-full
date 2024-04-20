package com.educlaas.helpdesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educlaas.helpdesk.dao.Equipment;
import com.educlaas.helpdesk.service.EquipmentService;


@RestController
@RequestMapping(value = "/api")
public class EquipmentController {

	    @Autowired
	    private EquipmentService equipmentService;
	    
	  	//To View the stores
	  	@GetMapping("/equipments")
	  	public List<Equipment> getAllEquipments() {
	  		//Get all the stores
	  		return equipmentService.getAllEquipments();
	  		
	  	}
}
