package com.example.hospital_management_system.controller;


import com.example.hospital_management_system.dto.LoginRequest;
import com.example.hospital_management_system.dto.RegisterRequest;
import com.example.hospital_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public  String registerUser( @RequestBody RegisterRequest request){
        userService.registerUser(request);
        return "User Register Successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return userService.loginUser(request); // Returns JWT token
    }

}
