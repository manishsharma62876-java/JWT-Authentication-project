package com.manish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.manish.entity.UserRegister;
import com.manish.service.UserRegisterService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRegisterService service;

    @PostMapping("/register")
    public ResponseEntity<UserRegister> register(@RequestBody UserRegister user) {
        return ResponseEntity.ok(service.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserRegister user) {
        return ResponseEntity.ok(service.login(user));
    }
}