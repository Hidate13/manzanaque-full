package com.educlaas.helpdesk.service;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.educlaas.helpdesk.dao.Software;
import com.educlaas.helpdesk.repository.SoftwareRepository;

@Service
@Transactional
public class SoftwareService {

	@Autowired
	private SoftwareRepository softwareRepo;
	
	public List<Software> getAllSoftwares(){
		return softwareRepo.findAll();
		
	}
	
	public Software saveSoftware(Software software) {
		return softwareRepo.save(software);
	}
	
	public Software getSearchBy2Params(String equipmentMake, String equipmentType) {
		return softwareRepo.findEquipmentBy2Param(equipmentMake, equipmentType);
	}
}
