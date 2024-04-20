package com.educlaas.helpdesk.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.educlaas.helpdesk.dao.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	Optional<Users> findByEmail(String email);
	
	 //Check or Find existing mail - return true or false
    //For Register (duplicate mail)
    Boolean existsByEmail(String email);

//	@Query("SELECT u FROM Users u WHERE u.user_name = :user_name AND u.role = :role")
//	Users findEquipmentBy2Param(@Param("user_name") String user_name, @Param("role") String role);


}
