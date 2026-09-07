package com.pyramidreel.api.service;

import com.pyramidreel.api.dto.user.AuthDTO;
import com.pyramidreel.api.dto.user.RegisterDTO;
import com.pyramidreel.api.infra.security.TokenService;
import com.pyramidreel.api.model.user.User;
import com.pyramidreel.api.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthBusinessService {
    private final UserRepository repository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final BCryptPasswordEncoder encoder;

    public AuthBusinessService(UserRepository repository, AuthenticationManager authenticationManager, TokenService tokenService, BCryptPasswordEncoder encoder) {
        this.repository = repository;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.encoder = encoder;
    }

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
