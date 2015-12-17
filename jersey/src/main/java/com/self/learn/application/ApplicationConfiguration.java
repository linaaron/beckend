package com.self.learn.application;

import com.self.learn.resource.MyResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by aaronl on 10/12/2015.
 */
public class ApplicationConfiguration extends ResourceConfig {
    private static final Logger LOG = LoggerFactory.getLogger(ApplicationConfiguration.class);

    public ApplicationConfiguration() {
//        packages("com.self.learn");
        register(MyResource.class);
    }
}
