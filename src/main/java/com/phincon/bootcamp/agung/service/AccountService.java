package com.phincon.bootcamp.agung.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.phincon.bootcamp.agung.model.Account;

@Service
public interface AccountService {

    public Account getAccount();

    public List<Account> getAccounts();

    public Account save(Account account);

    public Account getAccountById(int id);
}
