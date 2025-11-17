package com.pyramidreel.api.service.impl;

import com.pyramidreel.api.infra.security.TokenService;
import com.pyramidreel.api.model.user.AuthDTO;
import com.pyramidreel.api.model.user.RegisterDTO;
import com.pyramidreel.api.model.user.User;
import com.pyramidreel.api.repository.UserRepository;
import com.pyramidreel.api.service.AuthBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthBusinessServiceImpl implements AuthBusinessService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public String login(AuthDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        return tokenService.generateToken((User) auth.getPrincipal());
    }

    public void register(RegisterDTO data) {
        if (repository.findByUsername(data.username()) != null)
            throw new RuntimeException("Username already in use");

        String encryptedPassword = encoder.encode(data.password());
        User newUser = new User(data.username(), encryptedPassword, data.role());

        repository.save(newUser);
    }
}
