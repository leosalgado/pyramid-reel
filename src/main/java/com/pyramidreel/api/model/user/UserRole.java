package com.pyramidreel.api.model.user;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("admin"),
    PRO("pro"),
    USER("user");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }
}
