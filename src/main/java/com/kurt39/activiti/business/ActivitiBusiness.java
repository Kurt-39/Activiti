package com.kurt39.activiti.business;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: maoyu
 * @Date: 2020/3/17 18:14
 * @Description: 全部实例的挂起
 */
public class ActivitiBusiness {

    public static void main(String[] args) {
      Logger logger = LoggerFactory.getLogger(ActivitiBusiness.class);
      ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
      ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
      RepositoryService repositoryService = processEngine.getRepositoryService();
      ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId("2501").singleResult();
        boolean suspended = processDefinition.isSuspended();
        if (suspended){
            repositoryService.activateProcessDefinitionById(processDefinition.getId(),true,null);
        }else{
            repositoryService.suspendProcessDefinitionById(processDefinition.getId(),true,null);
        }
    }
}
