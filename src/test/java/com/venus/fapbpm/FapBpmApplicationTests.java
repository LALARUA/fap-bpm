package com.venus.fapbpm;

import com.venus.fapbpm.dto.UserRole;
import com.venus.fapbpm.dto.UserWithRoles;
import com.venus.fapbpm.mapper.RoleMapper;
import com.venus.fapbpm.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FapBpmApplicationTests {
    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        List<UserRole> zsx = userMapper.getUserRoles("zx");
        System.out.println(5);
    }

}
