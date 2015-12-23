package com.self.learn.resource;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Component;

import javax.ws.rs.Path;

@Component
@Api(value = "contacts-api", description = "有关于用户的CURD操作", position = 5)
@Path("/contacts")
public class SwaggerResource {
}
