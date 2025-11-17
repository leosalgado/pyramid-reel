package com.pyramidreel.api.service;

import com.pyramidreel.api.model.user.AuthDTO;
import com.pyramidreel.api.model.user.RegisterDTO;

public interface AuthBusinessService {
    String login(AuthDTO data);

    void register(RegisterDTO data);
}
