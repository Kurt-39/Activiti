package com.kurt39.activiti.business;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: maoyu
 * @Date: 2020/3/17 18:14
 * @Description: 单个实例的挂起
 */
public class ActivitiBusiness1 {

    public static void main(String[] args) {
      Logger logger = LoggerFactory.getLogger(ActivitiBusiness1.class);
      ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
      ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processDefinitionId("").singleResult();
        boolean suspended = processInstance.isSuspended();
        if (suspended){
            runtimeService.activateProcessInstanceById(processInstance.getId());
        }else{
            runtimeService.suspendProcessInstanceById(processInstance.getId());
        }
    }
}
