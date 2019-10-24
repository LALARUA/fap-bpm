package com.venus.fapbpm.service;


import com.venus.fapbpm.dto.UserRole;
import com.venus.fapbpm.dto.UserWithRoles;
import com.venus.fapbpm.entity.Role;
import com.venus.fapbpm.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 获取用户所有权限
     * @param username
     * @return
     */
    List<UserRole> userRoles(String username);

    /**
     * 根据用户名称查询用户
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    void loginValidate(User user) throws Exception;



}
