package com.demo.controller;

import com.demo.model.Account;
import com.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private AccountService accountService;

    @RequestMapping("/login")
    private String hello(Model model, HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account account = accountService.getAccount(username, password);
        model.addAttribute("account",account);
        return "welcome";
    }


}
