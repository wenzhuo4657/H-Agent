package cn.wenzhuo4657.ai.test;

import cn.wenzhuo4657.ai.infrastructure.dao.AiAgentDao;
import cn.wenzhuo4657.ai.infrastructure.dao.po.AiAgent;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class MysqlDataSourceTest {



    @Autowired
    private AiAgentDao aiAgentDao;

    /**
     * mysql数据库执行测试
     */
    @Test
    public void mysqlTest() {
        log.info("开始执行测试");
        AiAgent aiAgent = new AiAgent();
        aiAgent.setId(1l);//todo 这里插入id失效，数据在存的时候会自己重写
        aiAgent.setAgentId("1");
        aiAgent.setAgentName("测试");
        aiAgent.setDescription("测试");
        aiAgent.setChannel("mysql");
        aiAgent.setStatus(1);
        aiAgent.setCreateTime(new java.util.Date());
        aiAgent.setUpdateTime(new java.util.Date());
        int i = aiAgentDao.insert(aiAgent);
        log.info("插入结果：{}",i);
        i = aiAgentDao.deleteById(1l);
        log.info("删除结果：{}",i);
    }
}
