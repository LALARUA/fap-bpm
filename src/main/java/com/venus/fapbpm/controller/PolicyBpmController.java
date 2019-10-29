package com.venus.fapbpm.controller;

import com.venus.fapbpm.entity.PolicyApply;
import com.venus.fapbpm.pojo.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/policyBpm")
@RestController
public class PolicyBpmController {

    /**
     * 策略变更
     * @return
     */
    @PostMapping("/startPolicyApply")
    public ResponseEntity startAlterPolicy(PolicyApply policyApply){
        return new ResponseEntity();
    }


}
