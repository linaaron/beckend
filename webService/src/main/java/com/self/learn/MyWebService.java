package com.self.learn;

import com.self.learn.domain.Person;
import com.self.learn.exception.HelloException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

@WebService(name = "MyWebService", targetNamespace = "http://www.aaronl.com/wstest",
        serviceName = "myWebService")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class MyWebService {
    private ArrayList<Person> persons = new ArrayList<>();

    @WebMethod(operationName = "toSayHello", action = "sayHello", exclude = false)
    @WebResult(name = "returnWord")
    public String sayHello(@WebParam(name = "userName") String userName) {
        return String.format("Hello: %s", userName);
    }

    @WebMethod(operationName = "sayHello", action = "sayHello")
    @WebResult(partName = "personList")
    public Person[] sayHello(@WebParam(partName = "person", mode = WebParam.Mode.IN) Person person,
                             String userName) throws HelloException {
        if (person == null || person.getName() == null) {
            throw new HelloException("");
        }
        System.out.println(person.getName() + "|||" + userName + "|||" + person.getAge());
        persons.add(person);
        return persons.toArray(new Person[0]);
    }
}

