package com.kurt39.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: maoyu
 * @Date: 2020/3/16 17:39
 * @Description:
 */
public class ActivitiTaskQuery {
    public static void main(String[] args) {
        Logger logger1 = LoggerFactory.getLogger(ActivitiBuildController.class);
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
        ProcessEngine processEngine = configuration.buildProcessEngine();
        TaskService taskService = processEngine.getTaskService();
       /* List<Task> list = taskService.createTaskQuery()
                .processDefinitionKey("leaveProcess")
                .taskCandidateOrAssigned("左慧君")
                .list();
        for (Task task:list) {
            String processDefinitionId=task.getProcessDefinitionId(),assignee =task.getAssignee(),id = task.getId(),name = task.getName();
            logger1.info("实例id="+processDefinitionId);
            logger1.info("处理人名称"+assignee);
            logger1.info("处理人ID"+id);
            logger1.info("处理人名称"+name);
        }*/
        Task task = taskService.createTaskQuery().processDefinitionKey("leaveProcess").taskCandidateOrAssigned("盐盐").singleResult();
        taskService.complete(task.getId());
        logger1.info("完成的流程id为" + task.getId());
    }
}
