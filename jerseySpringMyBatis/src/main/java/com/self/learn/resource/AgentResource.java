package com.self.learn.resource;

import com.self.learn.domain.Agent;
import com.self.learn.service.AgentService;
import com.self.learn.validation.constraints.Year;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;

@Component
@Path("agent")
public class AgentResource {
    private static final Logger LOG = LoggerFactory.getLogger(AgentResource.class);

    @Autowired
    private AgentService agentService;

    @Context
    private ResourceInfo resourceInfo;

    @GET
    @Path("/{agentId}/{year}")
    public Agent getAgentById(@PathParam("agentId") Integer agentId,
                              @Year @PathParam("year") Integer year) {

        LOG.info("afaf");
//        return null;TODO
        return agentService.getAgentById(agentId);
    }
}
