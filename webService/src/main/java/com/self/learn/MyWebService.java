package com.self.learn;

import com.self.learn.domain.Person;
//import com.self.learn.exception.HelloException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Binding;
import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@WebService(name = "MyWebService", targetNamespace = "http://www.aaronl.com/wstest",
        serviceName = "myWebService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class MyWebService {
    private ArrayList<Person> persons = new ArrayList<>();

    @WebMethod(operationName = "toSayHello", action = "sayHello")
    @WebResult(name = "returnWord")
    public String sayHello(@WebParam(name = "userName") String userName) {
        return String.format("Hello: %s", userName);
    }

//    @WebMethod(exclude = true)
    public String sayHelloTwo(Integer name) {
        return "sayHelloTwo";
    }

    @WebMethod(operationName = "sayHello", action = "sayHello")
    @WebResult(partName = "personList")
    public Person[] sayHello(@WebParam(partName = "person", mode = WebParam.Mode.IN) Person person,
                             String userName) {
        if (person == null || person.getName() == null) {
//            throw new HelloException("");
        }
        System.out.println(person.getName() + "|||" + userName + "|||" + person.getAge());
        persons.add(person);
        return persons.toArray(new Person[0]);
    }

    public static void main(String[] args) {
        /*
         * 生成Example 服务实例
         */
//        Example serverBean = new Example();
        /*
         * 发布Web Service到http://localhost:8080/hello地址
         */
        Endpoint endpoint =
                Endpoint.publish("http://localhost:8080/hello", new MyWebService());
//        Binding binding = endpoint.getBinding();
        /*
         * 设置一个SOAP协议处理栈
         * 这里就简单得打印SOAP的消息文本
         */
//        List<Handler> handlerChain = new LinkedList<Handler>();
//        handlerChain.add(new TraceHandler());
//        binding.setHandlerChain(handlerChain);
        System.out.println("start success: http://localhost:8080/hello");

//        new myWebService();
    }
}

