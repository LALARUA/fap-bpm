package com.venus.fapbpm.utils;


import com.venus.fapbpm.definedAnnotation.DBFieldExplain;
import com.venus.fapbpm.entity.PolicyApply;

import java.lang.reflect.Field;

public class PolicyApplyUtils {
    public static void generateApplyDetail(PolicyApply policyApply) throws Exception{
        StringBuilder detail = new StringBuilder();
        Field[] declaredFields = policyApply.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            DBFieldExplain dbFieldExplain = field.getAnnotation(DBFieldExplain.class);
            if (dbFieldExplain != null){
                String line = new StringBuilder(dbFieldExplain.value()).append(":").append(field.get(policyApply)).toString();
                detail.append(line).append("\r\n");
            }
        }
    }
}
