package com.keyin.sprint.controller;

import com.keyin.sprint.model.Login;
import com.keyin.sprint.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@RestController
@RequestMapping("/api")
@SessionAttributes("user")
public class LoginController {

    private final LoginService loginService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginController(LoginService loginService, PasswordEncoder passwordEncoder) {
        this.loginService = loginService;
        this.passwordEncoder = passwordEncoder;
    }
//Login Handle
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login loginDetails) {
        Login loginUser = loginService.authenticate(loginDetails.getUsername(), loginDetails.getPassword());

        if (loginUser != null) {

            return ResponseEntity.ok("User authenticated successfully");
        } else {
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
    }
//Where a user can register
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Login loginDetails) {
        if (!loginService.userExists(loginDetails.getUsername())) {
            Login newUser = loginService.registerNewUser(loginDetails.getUsername(), loginDetails.getPassword());
            if (newUser != null) {
                return ResponseEntity.ok("User registered successfully");
            }
            // Handle registration failure (e.g., due to constraints)
            return ResponseEntity.badRequest().body("Registration failed");
        } else {
            return ResponseEntity.badRequest().body("Username already exists");
        }
    }
}
