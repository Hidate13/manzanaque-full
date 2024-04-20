package com.educlaas.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.educlaas.helpdesk.dao.Operator;
import com.educlaas.helpdesk.dao.Users;

public interface OperatorRepository extends	JpaRepository<Operator, Long> {
	
	 @Query("SELECT o FROM Operator o WHERE o.user_id = :users")
    Operator findByUserId(@Param("users") Users users);

}
