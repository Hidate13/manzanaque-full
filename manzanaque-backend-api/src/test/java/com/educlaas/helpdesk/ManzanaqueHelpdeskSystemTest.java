package com.educlaas.helpdesk;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.nio.file.attribute.UserPrincipal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import com.educlaas.helpdesk.dao.*;
import com.educlaas.helpdesk.repository.UsersRepository;
import com.educlaas.helpdesk.service.CallerService;
import com.educlaas.helpdesk.service.UsersPrincipal;



@SpringBootTest
class ManzanaqueHelpdeskSystemTest {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private CallerService CallerSvc;
	private UsersPrincipal UP;
	
	@Bean
	public CallerService  CallerService() {
		return CallerService();
	}
	
	
	@Test
	public void searchCallerID() {
		 Caller caller =  CallerSvc.getCallerById((long) 1);
		 //Test is successful when actual result & expect result = wahyu.hidate.hidayat@gmail.com
		 assertNotNull(caller);	
	}
	
}
