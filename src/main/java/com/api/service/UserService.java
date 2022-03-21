package com.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.exception.NotExistIdException;
import com.api.model.Product;
import com.api.model.User;
import com.api.repository.UserRepository;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;


@Service
public class UserService {
@Autowired
UserRepository ur;

public User register(User user)
{	
	return ur.save(user);
}

public User getUserByCredentials(User user) {

	User userSearch = this.getByEmail(user.getEmail());
	System.out.printf("Nombre del usuario encontrado: "+userSearch.getName());
	if(userSearch==null){
		System.out.printf("Retornando null");
		return null;
	}
	String hashPass = userSearch.getPassword();
	Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
	if(argon2.verify(hashPass,user.getPassword())) {
		System.out.printf("Todo correcto");
		return userSearch;
	}else {
		return null;
	}
	
}

	public User getByEmail(String email){
		return ur.findByEmail(email);
	}
	
	public List<User> findAll(){
		List<User> list = ur.findAll();
		return list;  
	}
	
	public void delete (int iduser) {
		if(this.existsById(iduser)) {
			ur.deleteById(iduser);
		}
		throw new NotExistIdException("602","No exist Id");
	}
	
	public boolean existsById(int iduser) {
		return ur.existsById(iduser); 
	}

}
