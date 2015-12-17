package com.self.learn.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by aaronl on 10/12/2015.
 */
@Path("myResource")
public class MyResource {
//    http://localhost:8080/jersey/api/myResource/sayHello
    @Path("/sayHello")
    @GET
    @Produces("text/plan")
    public String sayHello() {
        return "Hello !!!";
    }

    /*@Path("/{name}")
    @GET
    public String getResource(@PathParam("name") String name) {
        return String.format(" the response is: %s", name);
    }*/

}
