package com.pyramidreel.api.model.user;

public enum UserRole {
    ADMIN("admin"),
    PRO("pro"),
    USER("user");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
