package com.self.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWordController {
//    http://localhost:8080/springMVC/hello?name=abc
    @RequestMapping("/hello")
    public String Hello(@RequestParam(value = "name", required = false, defaultValue = "aaron lin") String name, Model model) {
        model.addAttribute("name", name);
        return "helloworld";
    }

}
