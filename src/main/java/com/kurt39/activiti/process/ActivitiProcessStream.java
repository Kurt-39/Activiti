package com.kurt39.activiti.process;

import com.kurt39.activiti.ActivitiBuildController;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: maoyu
 * @Date: 2020/3/16 17:39
 * @Description:
 */
public class ActivitiProcessStream {
    public static void main(String[] args) throws IOException {
        Logger logger1 = LoggerFactory.getLogger(ActivitiBuildController.class);
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
        ProcessEngine processEngine = configuration.buildProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey("leaveProcess").singleResult();
        String diagramResourceName = processDefinition.getDiagramResourceName();
        String resourceName = processDefinition.getResourceName();
        InputStream bpmnIs = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), diagramResourceName);
        InputStream pngIs = repositoryService.getResourceAsStream(processDefinition.getDeploymentId(), resourceName);

        FileOutputStream bpmnOs = new FileOutputStream("/Users/maoyu/dev/input/" + diagramResourceName);
        FileOutputStream pngOs = new FileOutputStream("/Users/maoyu/dev/input/" + resourceName);

        IOUtils.copy(bpmnIs, bpmnOs);
        IOUtils.copy(pngIs, pngOs);

        bpmnIs.close();
        bpmnOs.close();
        pngIs.close();
        pngOs.close();
    }
}
