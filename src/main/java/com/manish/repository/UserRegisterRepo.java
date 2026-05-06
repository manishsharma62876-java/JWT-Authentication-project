package com.manish.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manish.entity.UserRegister;
@Repository
public interface UserRegisterRepo extends JpaRepository<UserRegister, Long> {

	Optional<UserRegister> findByEmail(String email); 
	
	Optional<UserRegister> findByFirstName(String firstName);
	
}
