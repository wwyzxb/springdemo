package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wuxiaobing
 * @Date 2017/11/17
 **/
@Controller
public class LoginController {
    @RequestMapping("/login")
    private String hello(Model model, HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        return "welcome";
    }

}
