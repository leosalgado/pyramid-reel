package com.pyramidreel.api.service;

import com.pyramidreel.api.model.user.User;

import java.util.List;

public interface UserService {
    User getById(Long id);

    List<User> getAll();
}
