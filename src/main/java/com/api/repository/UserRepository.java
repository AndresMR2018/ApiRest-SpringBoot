package com.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
 //method to search by email
	User findByEmail(String email);
	
}
