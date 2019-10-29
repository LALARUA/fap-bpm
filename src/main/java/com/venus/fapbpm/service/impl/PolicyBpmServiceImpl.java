package com.venus.fapbpm.service.impl;

import com.venus.fapbpm.entity.PolicyApply;
import com.venus.fapbpm.mapper.PolicyApplyMapper;
import com.venus.fapbpm.service.PolicyBpmService;
import com.venus.fapbpm.utils.PolicyApplyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyBpmServiceImpl implements PolicyBpmService {
    @Autowired
    private PolicyApplyMapper policyApplyMapper;

    @Override
    public void startPolicyApply(PolicyApply policyApply) throws Exception{
        PolicyApplyUtils.generateApplyDetail(policyApply);
        policyApplyMapper.insertSelective(policyApply);
    }
}
