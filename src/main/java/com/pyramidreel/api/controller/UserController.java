package com.pyramidreel.api.controller;

import com.pyramidreel.api.model.user.User;
import com.pyramidreel.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping
    public List<User> findAllUsers() {
        return userService.getAll();
    }

}
