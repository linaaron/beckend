package com.self.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @RequestMapping("/userInfo")
    public String UserInfo(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name", name);
        return "userInfo";
    }

    public void test(){
//        Complex
    }
}
