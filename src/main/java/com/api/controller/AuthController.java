package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Message;
import com.api.model.User;
import com.api.service.UserService;
import com.api.utils.JWTUtil;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class AuthController {

	@Autowired
	UserService us;
	
	@Autowired
	JWTUtil jwtUtil;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user) {
		
		User userSearched = us.getUserByCredentials(user);
		//System.out.printf("Nombre del usuario encontrado en auth: "+userSearched.getName());
		if(userSearched != null) {
			String token = jwtUtil.create(String.valueOf(userSearched.getId()),userSearched.getEmail());
			System.out.printf(token);
			return new ResponseEntity<String>(token, HttpStatus.OK);
		}
	
		return new ResponseEntity<String>("Error", HttpStatus.UNAUTHORIZED);
	}
}
