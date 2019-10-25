package com.venus.fapbpm.controller;

import com.venus.fapbpm.entity.User;
import com.venus.fapbpm.pojo.ResponseEntity;
import com.venus.fapbpm.pojo.StatusCode;
import com.venus.fapbpm.service.UserService;
import com.venus.fapbpm.utils.ResponseUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/loginValidate")
    public ResponseEntity login(@Valid User user, BindingResult bindingResult){
        try {
            userService.loginValidate(user);
        } catch (UnknownAccountException e) {
            return new ResponseEntity(StatusCode.UNKNOWN_ACCOUNT);
        } catch (AuthenticationException e) {
            return new ResponseEntity(StatusCode.AUTHENTICATE_ERROR);
        } catch (Exception e){
            return new ResponseEntity(StatusCode.ERROR);
        }
        return new ResponseEntity();

    }



}
