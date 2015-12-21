package com.self.learn.resource;

import com.self.learn.domain.Agent;
import com.self.learn.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Component
@Path("agent")
public class AgentResource {

    @Autowired
    private AgentService agentService;

    @GET
    @Path("/{agentId}")
    public Agent getAgentById(@PathParam("agentId") Integer agentId) {
        return agentService.getAgentById(agentId);
    }
}
