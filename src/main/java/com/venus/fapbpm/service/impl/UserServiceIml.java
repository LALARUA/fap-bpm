package com.venus.fapbpm.service.impl;

import com.venus.fapbpm.dto.UserRole;
import com.venus.fapbpm.dto.UserWithRoles;
import com.venus.fapbpm.entity.Role;
import com.venus.fapbpm.entity.User;
import com.venus.fapbpm.mapper.UserMapper;
import com.venus.fapbpm.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceIml implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<UserRole> userRoles(String username) {
        List<UserRole> userRoles = userMapper.getUserRoles(username);
        return userRoles;
    }

    @Override
    public User getUserByUsername(String username) {
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("username",username);
        return userMapper.selectOneByExample(example);
    }

    @Override
    public void loginValidate(User user){
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            currentUser.login(token);
        }
    }
}
