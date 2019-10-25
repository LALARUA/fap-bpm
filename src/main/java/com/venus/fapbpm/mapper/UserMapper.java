package com.venus.fapbpm.mapper;


import com.venus.fapbpm.dto.UserRole;
import com.venus.fapbpm.dto.UserWithRoles;
import com.venus.fapbpm.entity.User;
import com.venus.mapper.MyMapper;

import java.util.List;

public interface UserMapper extends MyMapper<User> {
    List<UserRole> getUserRoles(String username);
}