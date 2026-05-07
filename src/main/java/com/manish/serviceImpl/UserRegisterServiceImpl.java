//package com.manish.serviceImpl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.manish.entity.UserRegister;
//import com.manish.repository.UserRegisterRepo;
//import com.manish.security.JwtUtil;
//import com.manish.service.UserRegisterService;
//
//@Service
//public class UserRegisterServiceImpl implements UserRegisterService {
//
//	@Autowired
//	private UserRegisterRepo userRegisterRepo;
//
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	@Autowired
//	private JwtUtil jwtUtil;
//
//	@Override
//	public String insertUserRegister(UserRegister userRegister) {
//		userRegisterRepo.save(userRegister);
//		return "Register data successfullyy......";
//	}
//
//	@Override
//	public List<UserRegister> getAllUser() {
//
//		return userRegisterRepo.findAll();
//	}
//
//	@Override
//	public UserRegister getUserById(Integer id) {
//
//		return userRegisterRepo.findById(id).orElseThrow((() -> new RuntimeException("User id not found::" + id)));
//	}
//
//	@Override
//	public String updateUser(UserRegister userRegister) {
//		userRegisterRepo.findById(userRegister.getId()).orElseThrow(() -> new RuntimeException("User is not found::"));
//		userRegisterRepo.save(userRegister);
//		return "User Updated Successfullyy.......";
//	}
//
//	@Override
//	public String deleteuser(long id) {
//
//		userRegisterRepo.findById(id).orElseThrow(() -> new RuntimeException("User id not found::"));
//		userRegisterRepo.deleteById(id);
//		return "Data deleted succeesffulyyy....";
//	}
//
//	@Override
//	public UserRegister findUserByEmail(String email) {
//		return userRegisterRepo.findByEmail(email).orElseThrow(() -> new RuntimeException("Email id not found::"));
//	}
//
//	@Override
//	public boolean existsById(long id) {
//
//		return userRegisterRepo.existsById(id);
//	}
//
//	@Override
//	public long totalUser() {
//
//		return userRegisterRepo.count();
//	}
//
//	@Override
//	public UserRegister findUsername(String firstName) {
//
//		return userRegisterRepo.findByFirstName(firstName).orElseThrow(() -> new RuntimeException("Name not found..."));
//
//	}
//
//	@Override
//	public UserRegister register(UserRegister user) {
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		return userRegisterRepo.save(user);
//	}
//
//	@Override
//	public String login(UserRegister user) {
//
//		UserRegister dbUser = userRegisterRepo.findByEmail(user.getEmail())
//				.orElseThrow(() -> new RuntimeException("User not found"));
//
//		if (!passwordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
//			throw new RuntimeException("Invalid credentials");
//		}
//		return jwtUtil.generateToken(dbUser.getEmail());
//	}
//
//}

package com.manish.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.manish.entity.UserRegister;
import com.manish.repository.UserRegisterRepo;
import com.manish.security.JwtUtil;
import com.manish.service.UserRegisterService;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

	@Autowired
	private UserRegisterRepo userRegisterRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtUtil jwtUtil;

	// INSERT USER
	@Override
	public String insertUserRegister(UserRegister userRegister) {

		// Encrypt password before saving
		userRegister.setPassword(passwordEncoder.encode(userRegister.getPassword()));

		userRegisterRepo.save(userRegister);

		return "Register data successfully...";
	}

	// GET ALL USERS
	@Override
	public List<UserRegister> getAllUser() {

		return userRegisterRepo.findAll();
	}

	// GET USER BY ID
	@Override
	public UserRegister getUserById(Long id) {

		return userRegisterRepo.findById(id).orElseThrow(() -> new RuntimeException("User id not found :: " + id));
	}

	// UPDATE USER
	@Override
	public String updateUser(UserRegister userRegister) {

		UserRegister existingUser = userRegisterRepo.findById(userRegister.getId())
				.orElseThrow(() -> new RuntimeException("User not found"));

		existingUser.setFirstName(userRegister.getFirstName());
		existingUser.setLastName(userRegister.getLastName());
		existingUser.setEmail(userRegister.getEmail());
		existingUser.setContactId(userRegister.getContactId());

		// Encrypt updated password
		existingUser.setPassword(passwordEncoder.encode(userRegister.getPassword()));

		userRegisterRepo.save(existingUser);

		return "User Updated Successfully...";
	}

	// DELETE USER
	@Override
	public String deleteuser(long id) {

		userRegisterRepo.findById(id).orElseThrow(() -> new RuntimeException("User id not found :: " + id));

		userRegisterRepo.deleteById(id);

		return "Data deleted successfully...";
	}

	// FIND USER BY EMAIL
	@Override
	public UserRegister findUserByEmail(String email) {

		return userRegisterRepo.findByEmail(email)
				.orElseThrow(() -> new RuntimeException("Email id not found :: " + email));
	}

	// CHECK USER EXISTS
	@Override
	public boolean existsById(long id) {

		return userRegisterRepo.existsById(id);
	}

	// TOTAL USERS
	@Override
	public long totalUser() {

		return userRegisterRepo.count();
	}

	// FIND USERNAME
	@Override
	public UserRegister findUsername(String firstName) {

		return userRegisterRepo.findByFirstName(firstName).orElseThrow(() -> new RuntimeException("Name not found..."));
	}

	// REGISTER USER
	@Override
	public UserRegister register(UserRegister user) {

		// Encrypt password
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		return userRegisterRepo.save(user);
	}

	// LOGIN USER
	@Override
	public String login(UserRegister user) {

		UserRegister dbUser = userRegisterRepo.findByEmail(user.getEmail())
				.orElseThrow(() -> new RuntimeException("User not found"));

		// Match raw password with encrypted password
		boolean isPasswordMatch = passwordEncoder.matches(user.getPassword(), dbUser.getPassword());

		if (!isPasswordMatch) {
			throw new RuntimeException("Invalid credentials");
		}

		// Generate JWT Token
		return jwtUtil.generateToken(dbUser.getEmail());
	}

	@Override
	public List<UserRegister> registerAll(List<UserRegister> users) {

		users.forEach(user -> {

			user.setPassword(passwordEncoder.encode(user.getPassword()));

		});

		return userRegisterRepo.saveAll(users);
	}
}
