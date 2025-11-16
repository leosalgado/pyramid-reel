package com.pyramidreel.api.model.user;

public record RegisterDTO(String username, String password, UserRole role) {
}
