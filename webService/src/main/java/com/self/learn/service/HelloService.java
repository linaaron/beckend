package com.self.learn.service;

import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface HelloService {

    public String sayHello(@WebParam(name = "name") String name);

}
