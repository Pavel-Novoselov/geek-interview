package com.geek.lesson7.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspControllers {

    @RequestMapping("/")
    public String student() {
        return "/student";
    }

}
