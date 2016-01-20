package com.self.learn.service.impl;

import com.self.learn.service.HelloService;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService
//@SOAPBinding(style = SOAPBinding.Style.RPC)
public class HelloServiceImpl {

    public String sayHello(String name) {
        return "My name is: " + name;
    }

    public String sayHelloToPerson() {
        return "";
    }


    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9001/Service/HelloService", new HelloServiceImpl());
        System.out.println("service success");
    }
}
