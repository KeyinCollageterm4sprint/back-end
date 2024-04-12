package com.keyin.sprint.service;

import com.keyin.sprint.model.Login;
import com.keyin.sprint.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final LoginRepository loginRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginService(LoginRepository loginRepository, PasswordEncoder passwordEncoder) {
        this.loginRepository = loginRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean userExists(String username) {
        return loginRepository.findByUsername(username) != null;
    }

    public Login registerNewUser(String username, String password) {
        if (!userExists(username)) {
            Login newUser = new Login();
            newUser.setUsername(username);
            newUser.setPassword(passwordEncoder.encode(password)); // Encode password
            return loginRepository.save(newUser); // Save new user with encoded password
        }
        return null; // or throw an exception if user already exists
    }

    public Login authenticate(String username, String rawPassword) {
        Login login = loginRepository.findByUsername(username);
        if (login != null && passwordEncoder.matches(rawPassword, login.getPassword())) {
            return login; // return the login object if password matches
        }
        return null;
    }
}
