package com.manish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.manish.entity.UserRegister;
import com.manish.service.UserRegisterService;

@RestController
@RequestMapping("/User")
public class UserRegisterController {

	@Autowired
	private UserRegisterService userRegisterService;

	@PostMapping("/userregister")
	public ResponseEntity<String> insertUserRegister(@RequestBody UserRegister userRegister) {
		String msg = userRegisterService.insertUserRegister(userRegister);
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}

	@GetMapping("/getAllUser")
	public ResponseEntity<List<UserRegister>> getAllUsers() {
		List<UserRegister> allUser = userRegisterService.getAllUser();
		return new ResponseEntity<List<UserRegister>>(allUser, HttpStatus.OK);

	}

	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id) {
		UserRegister userById = userRegisterService.getUserById(id);
		return new ResponseEntity<>(userById, HttpStatus.OK);

	}

	@PutMapping("/update")
	public ResponseEntity<String> updateUser(@RequestBody UserRegister userRegister) {
		String updateUser = userRegisterService.updateUser(userRegister);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteuser(@PathVariable Integer id) {
		String msg = userRegisterService.deleteuser(id);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<UserRegister> findByUserByEmail(@PathVariable String email) {
		UserRegister userByEmail = userRegisterService.findUserByEmail(email);
		return new ResponseEntity<>(userByEmail, HttpStatus.OK);
	}

	@GetMapping("exists/{id}")
	public ResponseEntity<Boolean> ExistById(@PathVariable Integer id) {
		boolean existsById = userRegisterService.existsById(id);
		return new ResponseEntity<>(existsById, HttpStatus.OK);
	}

	@GetMapping("/count")
	public ResponseEntity<Long> totalUser() {
		long totalUser = userRegisterService.totalUser();
		return new ResponseEntity<>(totalUser, HttpStatus.OK);
	}

	@GetMapping("/firstName/{firstName}")
	public ResponseEntity<UserRegister> getByFirstName(@PathVariable String firstName) {
		UserRegister byname = userRegisterService.findUsername(firstName);
		return new ResponseEntity<>(byname, HttpStatus.OK);
	}
	
	@PostMapping("/registerAll")
	public ResponseEntity<List<UserRegister>> registerAll(@RequestBody List<UserRegister> register){
		List<UserRegister> registerAll = userRegisterService.registerAll(register);
		return new ResponseEntity<>(registerAll,HttpStatus.OK);
	}
}
