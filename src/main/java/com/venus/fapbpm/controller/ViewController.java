package com.venus.fapbpm.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String login(){
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()){
            return "index";
        }
        return "login";
    }

}
