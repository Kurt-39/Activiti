package com.kurt39.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

/**
 * @Author: maoyu
 * @Date: 2020/3/16 11:39
 * @Description:
 */
public class ActivitiBuildController {

    public static void main(String[] args) {
        Logger logger1 = LoggerFactory.getLogger(ActivitiBuildController.class);
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        ProcessEngine processEngine = configuration.buildProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
       /* Deployment deploy = repositoryService.createDeployment().disableSchemaValidation()
                .addClasspathResource("bpmn/leave.bpmn")
                .addClasspathResource("bpmn/leave.png")
                .name("离职流程")
                .deploy();*/
        InputStream resourceAsStream = ActivitiBuildController.class.getClassLoader().getResourceAsStream("bpmn/leave.zip");
        ZipInputStream zipInputStream = new ZipInputStream(resourceAsStream);
        Deployment deploy = repositoryService.createDeployment().disableSchemaValidation().addZipInputStream(zipInputStream).deploy();
        String name = deploy.getName(), id = deploy.getId(), description = deploy.getDeploymentTime() + "";
        System.out.println("name=" + name + "====" + "id" + id + "===" + "description" + description);
        logger1.info(name);
    }
}
