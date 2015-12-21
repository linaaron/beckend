package com.self.learn.dao;

import com.self.learn.domain.Agent;
import org.apache.ibatis.annotations.Param;

public interface AgentDao {
    Agent getAgentById(@Param("agentId") Integer agentId);
}
