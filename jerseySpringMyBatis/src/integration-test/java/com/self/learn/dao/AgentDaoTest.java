package com.self.learn.dao;

import com.self.learn.domain.Agent;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AgentDaoTest extends BaseDaoTest {

    @Autowired
    private AgentDao agentDao;

    @Test
    public void testGetAgentById() {
        Agent agent = agentDao.getAgentById(11144);
        System.out.println(agent.getUserId());
    }
}
