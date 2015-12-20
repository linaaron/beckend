package com.self.learn.resource;

import com.self.learn.bean.OptionResult;
import com.self.learn.bean.User;
import com.self.learn.domain.Account;
import com.self.learn.domain.Gender;
import com.self.learn.domain.Person;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Path("Demo")
public class DemoResource {

    @Context
    HttpServletRequest httpServletRequest;

    //    http://localhost:8080/jersey2/api/Demo/person/1
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "hello jersey";
    }

    @GET
    @Path("/person/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getDemoName(@DefaultValue("aaron lin") @PathParam("name") String name,
                              @QueryParam("age") int age) {
        Person person = new Person();
        person.setName(name + httpServletRequest.getRequestURI() + "/n" + httpServletRequest.getRequestURL());
//        person.setName(name);
        person.setAge(age);
        System.out.println("===============================" + name);
        return person;
    }

    @POST
    @Path("/formOne")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String formParam(@FormParam("name") String name) {
        return String.format("%s formParam success", name);
    }

    @POST
    @Path("/formTwo")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String formDateParam(@FormDataParam("name") String name) {
        return String.format("%s formDateParam success", name);
    }

    @PUT
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public User getUser(@BeanParam User user, @Context UriInfo ui) {
        MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
        MultivaluedMap<String, String> pathParams = ui.getPathParameters();
        OptionResult result = new OptionResult();
        result.setResult("1");
        result.setErrorMsg("success");
        return user;
    }
}

/*User user = new User();
        user.setName("aaron Lin");
        user.setGender(Gender.MALE);
        List<Account> accounts = new ArrayList<>();
        Account account = new Account();
        account.setId(1);
        account.setBalance(BigDecimal.valueOf(1900.2));
        account.setCardId("1111");
        account.setDate(LocalDateTime.now());
        accounts.add(account);
        account = new Account();
        account.setId(2);
        account.setBalance(BigDecimal.valueOf(5000));
        account.setCardId("625444548433");
        account.setDate(LocalDateTime.now());
        accounts.add(account);
        user.setAccounts(accounts);*/
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, Boolean.TRUE);