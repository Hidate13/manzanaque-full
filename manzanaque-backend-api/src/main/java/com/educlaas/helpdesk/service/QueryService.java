package com.educlaas.helpdesk.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educlaas.helpdesk.dao.Query;
import com.educlaas.helpdesk.repository.QueryRepository;



@Service
@Transactional
public class QueryService {

	@Autowired
	private QueryRepository queryRepo;
	
	public List<Query> getAllQueries(){
		return queryRepo.findAll();
		
	}
	
	public Query saveQeries(Query callID){
		return queryRepo.save(callID);
		
	}
	
	public Query getQueryById(Long callID) {
        return queryRepo.findById(callID).orElse(null);
    }
	
	public void deleteQuery(Long callID) {
		queryRepo.deleteById(callID);
	}
	
}
