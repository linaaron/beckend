package com.self.learn.resource;

import com.self.learn.domain.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Created by aaronl on 10/14/2015.
 */
@Component         //定义此类为spring组件,即bean类.
@Scope("prototype")   //Spring会针对每一个request请求都生成新的Jersey服务类实例，此方法不需要配置Spring RequsetContextListener
@Path("/restresource")
public class TestRestResource {

    //    1、无参数返回json格式，如返回xml，将Produces参数修改为MediaType.APPLICATION_XML
    @GET
    @Path("/getUser")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser() {
        User user = new User();
        user.setUserName("sed");
        user.setAge(29);
        return user;
    }

    //    2、@PathParam("id")获取URI中指定规则的参数
    @GET
    @Path("getUser/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getUserId(@PathParam("id") String id) {
        return id;
    }

    //    3、@QueryParam 用于获取GET请求中的查询参数
    @GET
    @Path("getId")
    @Produces(MediaType.TEXT_PLAIN)
    public String getId(@QueryParam("id") String id) {
        return id;
    }

    //    4、输入参数为xml格式，输出为json格式。可以根据需要切换produces和consumes的类型
    @POST
    @Path("insertUser")
    @Produces(MediaType.APPLICATION_JSON)  //指定发送请求的 MIME 类型
    @Consumes(MediaType.APPLICATION_XML)  //指定响应所能接受的 MIME 类型
    public User insertuser(User user) {
        return user;
    }

    //    5、BeanParam 当请求参数很多时，比如客户端提交一个修改用户的PUT请求，请求中包含很多项用户信息
    @PUT
    @Path("insertUserFromBean")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User inserthome(@BeanParam User user) {
        return user;
    }

    //    6、@FormParam 从POST请求的表单参数中获取数据
    @POST
    @Path("insertUserFromForm")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(MediaType.TEXT_PLAIN)
    public String insertuser(@FormParam("username") String userName, @FormParam("age") int age) {
        User user = new User();
        user.setUserName(userName);
        user.setAge(age);
        return user.toString();
    }

    //    7、多参数传递
    @POST
    @Path("map")
    @Produces(MediaType.TEXT_PLAIN)
    public String getMap(MultivaluedMap<String, String> formParams) {
        String result = "who:" + formParams.getFirst("who") + " ; what:" + formParams.getFirst("what");
        return formParams.toString();
    }

    //    8、
    @DELETE
    @Path("deleteUser/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteUser(@PathParam("id") String id) {
        //System.out.println(uriInfo.getAbsolutePath().toString());
        return "delete " + id;
    }
}
