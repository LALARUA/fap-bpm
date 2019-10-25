package com.venus.fapbpm.controller;

import com.venus.fapbpm.entity.AlterPolicyApply;
import com.venus.fapbpm.pojo.ResponseEntity;
import javafx.scene.control.Alert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RequestMapping("/diFirewallBpm")
@RestController
public class FirewallBpmController {

    /**
     * 策略变更
     * @return
     */
    @PostMapping("/startAlterPolicy")
    public ResponseEntity startAlterPolicy(@Valid AlterPolicyApply alterPolicyApply,BindingResult bindingResult){


        return new ResponseEntity();
    }


}
