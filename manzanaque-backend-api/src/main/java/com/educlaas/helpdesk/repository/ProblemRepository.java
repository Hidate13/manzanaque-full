package com.educlaas.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.educlaas.helpdesk.dao.Problem;

public interface ProblemRepository extends	JpaRepository<Problem, Long> {

}
