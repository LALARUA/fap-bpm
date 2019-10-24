package com.venus.fapbpm.dto;

import com.venus.fapbpm.entity.Role;
import com.venus.fapbpm.entity.User;

import java.util.List;

public class UserWithRoles extends User {

    private List<UserRole> roles;

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }
}
