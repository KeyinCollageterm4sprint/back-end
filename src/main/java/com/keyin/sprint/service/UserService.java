package com.keyin.sprint.service;

import com.keyin.sprint.model.Login;
import com.keyin.sprint.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final LoginRepository loginRepository;

    @Autowired
    public UserService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Long findUserIdByUsername(String username) {
        Login user = loginRepository.findByUsername(username);
        return user != null ? user.getId() : null;
    }
}
