package com.educlaas.helpdesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educlaas.helpdesk.dao.Users;
import com.educlaas.helpdesk.exception.ResourceNotFoundException;
import com.educlaas.helpdesk.repository.UsersRepository;
import com.educlaas.helpdesk.service.UsersPrincipal;

@RestController
@CrossOrigin(origins = "https://manzanaque-full.vercel.app")
@RequestMapping(value = "/api")
public class UsersController {
	
	@Autowired
	private UsersRepository usersRepo;

	@GetMapping("/user/me") 
	public Users getUser(@CurrentUser UsersPrincipal usersPrincipal) {
	   return usersRepo.findById((usersPrincipal.getUsersId())) 
	                .orElseThrow(() -> new ResourceNotFoundException("Users", "userId", usersPrincipal.getUsersId()));
	}
}
