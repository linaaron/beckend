package com.self.learn.application;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class JSMApplicationConfiguration extends ResourceConfig {

    public JSMApplicationConfiguration() {
        packages("com.self.learn");
        register(MultiPartFeature.class); //用jersey-media-multipart包时要加这句
        register(JacksonJsonProvider.class);
//        register(JacksonFeature.class);
//        register(DemoResource.class);
    }
}
