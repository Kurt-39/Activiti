package com.kurt39.activiti.process;

import com.kurt39.activiti.ActivitiBuildController;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Author: maoyu
 * @Date: 2020/3/16 17:39
 * @Description:
 */
public class ActivitiProcessQuery {
    public static void main(String[] args) {
        Logger logger1 = LoggerFactory.getLogger(ActivitiBuildController.class);
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
        ProcessEngine processEngine = configuration.buildProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        List<Deployment> list = repositoryService.createDeploymentQuery().processDefinitionKey("leaveProcess").orderByDeploymentId().desc().list();
        for (Deployment deployment : list) {
            String id = deployment.getId(),name = deployment.getName(), desc = deployment.getCategory(), key = deployment.getKey();
            System.out.println(id);
            System.out.println(name);
            System.out.println(desc);
            System.out.println(key);

        }
    }
}
