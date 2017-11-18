package com.demo.service;

import com.demo.dao.AccountDao;
import com.demo.exception.BusinessException;
import com.demo.exception.CommonMessage;
import com.demo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Vincent
 * @Date 2017/11/18 11:35
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    public Account getAccount(String username, String password) {
        List<Account> accountList = accountDao.findAccountsByUsername(username);
        if (accountList.size() <= 0) {
            throw new BusinessException(CommonMessage.BusinessMessage.ERROR_UNREGISTER_ACCOUNT);
        }
        Account account = checkAccount(accountList, password);
        if (account == null) {
            throw new BusinessException(CommonMessage.BusinessMessage.ERROR_WRONGPASSWORD);
        }
        return account;
    }

    private Account checkAccount(List<Account> accountList, String password) {
        for (Account account : accountList) {
            if (password.equals(account.getPassword())) {
                return account;
            }
        }
        return null;
    }
}
