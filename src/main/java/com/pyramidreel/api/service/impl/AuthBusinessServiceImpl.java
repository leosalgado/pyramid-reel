package com.pyramidreel.api.service.impl;

import com.pyramidreel.api.model.user.RegisterDTO;
import com.pyramidreel.api.model.user.User;
import com.pyramidreel.api.repository.UserRepository;
import com.pyramidreel.api.service.AuthBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthBusinessServiceImpl implements AuthBusinessService {
    @Autowired
    UserRepository repository;

    @Autowired
    BCryptPasswordEncoder encoder;

    public void register(RegisterDTO data) {
        if (repository.findByUsername(data.username()) != null)
            throw new RuntimeException("Username already in use");

        String encryptedPassword = encoder.encode(data.password());
        User newUser = new User(data.username(), encryptedPassword, data.role());

        repository.save(newUser);
    }
}
