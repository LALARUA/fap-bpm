package com.venus.fapbpm.dto;

import com.venus.fapbpm.entity.Role;
import com.venus.fapbpm.entity.User;

public class UserRole extends Role {
    private Integer userRoleId;

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }
}
