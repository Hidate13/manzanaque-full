package com.educlaas.helpdesk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.helpdesk.dao.Resolution;
import com.educlaas.helpdesk.repository.ResolutionRepository;



@Service
@Transactional
public class ResolutionService {

	@Autowired
    private ResolutionRepository resoRepo;

    public List<Resolution> getAllResolution() {
        return resoRepo.findAll();
    }

    public Resolution getResolutionById(Long resolutionID) {
        return resoRepo.findById(resolutionID).orElse(null);
    }

    public Resolution saveResolution(Resolution resolution) {
        return resoRepo.save(resolution);
    }

    public void deleteResolution(Long resolutionID) {
    	resoRepo.deleteById(resolutionID);
    }
}
