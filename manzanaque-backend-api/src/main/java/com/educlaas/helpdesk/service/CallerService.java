package com.educlaas.helpdesk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.helpdesk.dao.Caller;
import com.educlaas.helpdesk.repository.CallerRepository;

@Service
@Transactional
public class CallerService {
    @Autowired
    private CallerRepository callerRepo;

    public List<Caller> getAllCallers() {
        return callerRepo.findAll();
    }

    public Caller getCallerById(Long callerID) {
        return callerRepo.findById(callerID).orElse(null);
    }

    public Caller saveCaller(Caller caller) {
        return callerRepo.save(caller);
    }

    public void deleteCaller(Long callerID) {
    	callerRepo.deleteById(callerID);
    }

}
