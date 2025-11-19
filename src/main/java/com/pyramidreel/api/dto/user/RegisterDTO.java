package com.pyramidreel.api.dto.user;

import com.pyramidreel.api.model.user.UserRole;

public record RegisterDTO(String username, String password, UserRole role) {
}
