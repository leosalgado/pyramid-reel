package com.pyramidreel.api.service;

import com.pyramidreel.api.dto.user.AuthDTO;
import com.pyramidreel.api.dto.user.RegisterDTO;

public interface AuthBusinessService {
    String login(AuthDTO data);

    void register(RegisterDTO data);
}
