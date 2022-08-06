package com.example.hellospring.security;

public enum ApplicationPermission {
    USER_READ("user:read"),
    USER_WRITE("user:read"),
    COURSE_READ("course:read"),
    COURSE_WRITE("course:write");

    private final String permission;

    ApplicationPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
