package com.educlaas.helpdesk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.helpdesk.dao.Equipment;
import com.educlaas.helpdesk.repository.EquipmentRepository;

@Service
@Transactional
public class EquipmentService {

	@Autowired
	private EquipmentRepository equipmentRepo;
	
	public List<Equipment> getAllEquipments(){
		return equipmentRepo.findAll();
		
	}
	
	public Equipment getSearchBy2Params(String equipmentMake, String equipmentType) {
		return equipmentRepo.findEquipmentBy2Param(equipmentMake, equipmentType);
	}

	public Equipment saveEquipment(Equipment tmpEquipment) {
		// TODO Auto-generated method stub
			return equipmentRepo.save(tmpEquipment);
		
	}
}
