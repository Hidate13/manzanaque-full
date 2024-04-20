package com.educlaas.helpdesk.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.educlaas.helpdesk.dao.Specialist;
import com.educlaas.helpdesk.dao.Users;

public interface SpecialistRepository extends	JpaRepository<Specialist, Long> {
	
	@Query("SELECT o FROM Specialist o WHERE o.user_id = :users")
	Specialist findByUserId(@Param("users") Users users);
	
	@Query("SELECT s.expertise, u.userName FROM Specialist s JOIN s.user_id u")
    List<Users[]> getAllSpecialistsWithUsernames();

//	@Query("SELECT o FROM Operator o LEFT JOIN FETCH o.users u WHERE u.user_name = :userName")
//    Users findOperatorByUserName(@Param("userName") String userName);
//	
//	@Query("SELECT s FROM Specialist s LEFT JOIN s.users u WHERE u.user_name = :userName")
//    Users findSpecialistByUserName(@Param("userName") String userName);
}
