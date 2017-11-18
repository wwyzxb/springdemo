package com.demo.service;

import com.demo.model.Account;

/**
 * @Author Vincent
 * @Date 2017/11/18 11:35
 */
public interface AccountService {
    public Account getAccount(String username, String password);
}
