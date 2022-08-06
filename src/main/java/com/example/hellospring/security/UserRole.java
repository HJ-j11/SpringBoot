package com.example.hellospring.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.example.hellospring.security.ApplicationPermission.*;

public enum UserRole {
    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, USER_WRITE, USER_READ));

    private final Set<ApplicationPermission> permissions;

    UserRole(Set<ApplicationPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationPermission> getPermissions() {
        return permissions;
    }
}
