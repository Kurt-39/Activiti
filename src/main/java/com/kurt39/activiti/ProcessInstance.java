package com.kurt39.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RuntimeService;

/**
 * @Author: maoyu
 * @Date: 2020/3/16 15:42
 * @Description:
 */
public class ProcessInstance {
    public static void main(String[] args) {
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
        ProcessEngine processEngine = configuration.buildProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        org.activiti.engine.runtime.ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("leaveProcess");
        String define = processInstance.getDeploymentId(),domain = processInstance.getId(),activityId = processInstance.getBusinessKey();
        System.out.println(define);
        System.out.println(domain);
        System.out.println(activityId);
    }
}
