package com.educlaas.helpdesk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educlaas.helpdesk.dao.Operator;
import com.educlaas.helpdesk.dao.Specialist;
import com.educlaas.helpdesk.dao.Users;
import com.educlaas.helpdesk.exception.BadRequestException;
import com.educlaas.helpdesk.payload.AfterRegister;
import com.educlaas.helpdesk.payload.Register;
import com.educlaas.helpdesk.repository.OperatorRepository;
import com.educlaas.helpdesk.repository.SpecialistRepository;
import com.educlaas.helpdesk.repository.UsersRepository;

import org.springframework.validation.BindingResult;

@RestController
@RequestMapping(value = "/api")
public class RegisterController {
	@Autowired
	private UsersRepository usersRepository;
	

	@Autowired
	private SpecialistRepository specialistRepo;
	
	@Autowired
	private OperatorRepository operatorRepo;

//	@Autowired
//	private PasswordEncoder passwordEncoder;;

	// Register User for Local
	@PostMapping(value = "/register")
	public ResponseEntity<AfterRegister> registerUser(@Valid @RequestBody Register register,
			BindingResult bindingResult) {
		// Checking duplicate email
		if (usersRepository.existsByEmail(register.getEmail())) {
			throw new BadRequestException("Duplicate Email");
		}
		
		if (bindingResult.hasErrors()) {
			// Handle validation errors
			return ResponseEntity.badRequest().body(new AfterRegister(false, "Validation failed"));
		}
		
		// Create new register user
		Users users = new Users();
		users.setUserName(register.getUserName());
		users.setEmail(register.getEmail());
		users.setPassword(register.getPassword());
		users.setRole(register.getRole());

		
		// Encode Password
		//users.setPassword(passwordEncoder.encode(users.getPassword()));

		// Save new user in the database
		Users newUser = usersRepository.save(users);

		// Conditionally handle roles
		if ("Specialist".equalsIgnoreCase(users.getRole())) {
			Specialist specialist = new Specialist();
			specialist.setUser_id(newUser);
			// Set specialist-specific properties here
	        specialist.setExpertise(register.getSpecialist().getExpertise());
			specialistRepo.save(specialist);
		} else if ("Operator".equalsIgnoreCase(users.getRole())) {
			Operator operator = new Operator();
			operator.setUser_id(newUser);
			// Set operator-specific properties here
			operatorRepo.save(operator);
		}
		
		java.net.URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/me")
				.buildAndExpand(newUser.getUsersId()).toUri();

		// Return to RegisterResponse Payload
		return ResponseEntity.created(location).body(new AfterRegister(true, "Successful Register"));
	}

}
