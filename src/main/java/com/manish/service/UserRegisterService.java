package com.manish.service;

import java.util.List;

import com.manish.entity.UserRegister;

public interface UserRegisterService {

	public String insertUserRegister(UserRegister userRegister);
	
    public List<UserRegister> getAllUser();
    
    public UserRegister getUserById(Long id);
    
    public String updateUser(UserRegister userRegister);
    
    public String deleteuser(long id);
    
    public UserRegister findUserByEmail(String email);
	
    public boolean existsById(long id);
    
    public long totalUser();
    
    public UserRegister findUsername(String firstName);
    
    UserRegister register(UserRegister user);
    
    String login(UserRegister user);
    
    public List<UserRegister> registerAll(List<UserRegister> users);
    
}
