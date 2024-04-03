package com.keyin.sprint.service;

import com.keyin.sprint.model.Login;
import com.keyin.sprint.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public boolean authenticate(String username, String password) {
        Login login = loginRepository.findByUsername(username);
        return login != null && login.getPassword().equals(password);
    }
}
