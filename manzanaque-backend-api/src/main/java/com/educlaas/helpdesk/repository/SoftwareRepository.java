package com.educlaas.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.educlaas.helpdesk.dao.Software;

public interface SoftwareRepository extends	JpaRepository<Software, Long> {

	@Query("SELECT s FROM Software s WHERE s.softwareName = :softwareName AND s.serialNumber = :serialNumber")
	Software findEquipmentBy2Param(@Param("softwareName") String softwareName, @Param("serialNumber") String serialNumber);

}
