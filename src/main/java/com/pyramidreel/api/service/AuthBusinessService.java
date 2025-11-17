package com.pyramidreel.api.service;

import com.pyramidreel.api.model.user.RegisterDTO;

public interface AuthBusinessService {
    void register(RegisterDTO data);
}
