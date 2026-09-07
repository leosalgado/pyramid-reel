package com.pyramidreel.api.controller;

import com.pyramidreel.api.dto.user.AuthDTO;
import com.pyramidreel.api.dto.user.LoginResponseDTO;
import com.pyramidreel.api.dto.user.RegisterDTO;
import com.pyramidreel.api.service.AuthBusinessService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final AuthBusinessService authBusinessService;

    public AuthController(AuthBusinessService authBusinessService) {
        this.authBusinessService = authBusinessService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Validated AuthDTO data) {
        var token = authBusinessService.login(data);
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated RegisterDTO data) {
        authBusinessService.register(data);
        return ResponseEntity.ok().build();
    }

}
