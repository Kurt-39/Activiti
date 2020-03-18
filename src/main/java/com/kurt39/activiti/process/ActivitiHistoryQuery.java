package com.kurt39.activiti.process;

import com.kurt39.activiti.ActivitiBuildController;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.history.HistoricActivityInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Author: maoyu
 * @Date: 2020/3/16 17:39
 * @Description:
 */
public class ActivitiHistoryQuery {
    public static void main(String[] args) {
        Logger logger1 = LoggerFactory.getLogger(ActivitiBuildController.class);
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault();
        ProcessEngine processEngine = configuration.buildProcessEngine();
        HistoryService historyService = processEngine.getHistoryService();
        List<HistoricActivityInstance> list = historyService.createHistoricActivityInstanceQuery().processInstanceId("5001").list();
        for (HistoricActivityInstance historicActivityInstance : list) {
            String id = historicActivityInstance.getId(),name = historicActivityInstance.getActivityName(), desc = historicActivityInstance.getAssignee();
            System.out.println(id);
            System.out.println(name);
            System.out.println(desc);
        }
    }
}
