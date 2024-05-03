package com.educlaas.helpdesk.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.educlaas.helpdesk.jwtsecurity.TokenProvider;
import com.educlaas.helpdesk.payload.AfterLogin;
import com.educlaas.helpdesk.payload.Login;
import com.educlaas.helpdesk.service.UsersServiceImpl;

@RestController
@CrossOrigin(origins = "https://manzanaque-full.vercel.app")
@RequestMapping(value = "/api")
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	@Autowired
	private UsersServiceImpl userService;
	
	@GetMapping("/checkUserRole")
    public ResponseEntity<Map<String, Boolean>> checkUserRole(
            @RequestParam String email,
            @RequestParam String role) {

        boolean isValidRole = userService.checkUserRole(email, role);

        Map<String, Boolean> response = new HashMap<>();
        response.put("valid", isValidRole);

        return ResponseEntity.ok(response);
    }
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> loginUser(@RequestBody Login login){
		
		//Check Authentication
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		//If authentication is correct, provide the token
		String token =  tokenProvider.createToken(authentication);
		System.out.println("Token For current user "+token);
		
		return ResponseEntity.ok(new AfterLogin(token));
	}
}
