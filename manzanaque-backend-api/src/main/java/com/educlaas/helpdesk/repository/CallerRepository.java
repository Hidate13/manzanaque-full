package com.educlaas.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educlaas.helpdesk.dao.Caller;

public interface CallerRepository extends JpaRepository<Caller, Long> {

}
