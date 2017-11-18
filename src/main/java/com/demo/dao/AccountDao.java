package com.demo.dao;

import com.demo.model.Account;
import com.demo.repository.BaseRepository;

import java.util.List;

/**
 * @Author Vincent
 * @Date 2017/11/18 11:28
 */
public interface AccountDao extends BaseRepository<Account, Integer> {
    Account findByUsernameAndPassword(String username, String password);

    List<Account> findAccountsByUsername(String username);
}
