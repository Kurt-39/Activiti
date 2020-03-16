import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

public class ActivitiTets {

    /**
     * 功能描述:
     *
     * @param:
     * @return:
     * @auther: maoyu
     * @date: 2020/3/16 11:08 上午
     */
    @Test
    public void getActivitiBasic() {
        ProcessEngineConfiguration engineConfiguration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        ProcessEngine processEngine = engineConfiguration.buildProcessEngine();
        System.out.println(processEngine);
    }
}
