package com.educlaas.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.educlaas.helpdesk.dao.Equipment;


public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
	
	@Query("SELECT e FROM Equipment e WHERE e.equipmentMake = :equipmentMake AND e.equipmentType = :equipmentType")
	Equipment findEquipmentBy2Param(@Param("equipmentMake") String equipmentMake, @Param("equipmentType") String equipmentType);
}
