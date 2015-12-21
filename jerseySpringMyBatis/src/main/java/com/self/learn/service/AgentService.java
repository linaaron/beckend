package com.self.learn.service;

import com.self.learn.dao.AgentDao;
import com.self.learn.domain.Agent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentService {
    private static final Logger LOG = LoggerFactory.getLogger(AgentService.class);

    @Autowired
    private AgentDao agentDao;

    public Agent getAgentById(Integer agentId) {
        LOG.info("getAgentById: " + agentId);
        return agentDao.getAgentById(agentId);
    }
}
