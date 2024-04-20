package com.educlaas.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educlaas.helpdesk.dao.Query;

public interface QueryRepository extends JpaRepository<Query, Long> {

}
