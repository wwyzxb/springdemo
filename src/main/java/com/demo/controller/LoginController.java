package com.demo.controller;

import com.demo.model.Account;
import com.demo.service.AccountService;
import com.demo.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private AccountService accountService;

    @RequestMapping("/login")
    private String hello(Model model, HttpServletRequest request) {
        logger.info("login...");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Account account = accountService.getAccount(username, password);
        model.addAttribute("info", Result.returnSuccessResult(account));
        return "welcome";
    }
}
