package com.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Message;
import com.api.model.User;
import com.api.service.UserService;
import com.api.utils.JWTUtil;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService us;
	
	@Autowired
	JWTUtil jwtUtil;
	
	@PostMapping
	public ResponseEntity<Message> register(@RequestBody User user)
	{
		if(user.getName().isEmpty() ) {
			return new ResponseEntity<Message>(new Message("Name is empty"), HttpStatus.BAD_REQUEST);
		}
		if(user.getEmail().isEmpty()) {
			return new ResponseEntity<Message>(new Message("Email is empty"), HttpStatus.BAD_REQUEST);
		}
		if(user.getPassword().length()<8) {
			return new ResponseEntity<Message>(new Message("Password is very short"), HttpStatus.BAD_REQUEST);
		}
		
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		String hashedPass = argon2.hash(1, 1024, 1, user.getPassword());
		user.setPassword(hashedPass);
		us.register(user);
		return new ResponseEntity<Message>(new Message("User registered"), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> list(@RequestHeader(value="Authorization") String token){
		System.out.printf("valor del token recibido: "+token);
		  if (!validarToken(token)) { return null; }
		  List<User> list = us.findAll();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	  private boolean validarToken(String token) {
	        String usuarioId = jwtUtil.getKey(token);
	        return usuarioId != null;
	    }
	  
	  @DeleteMapping("/{userid}")
		public ResponseEntity<Void> deleteUserById(@PathVariable("userid") Integer userid){
			us.delete(userid);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	
	
	
}
