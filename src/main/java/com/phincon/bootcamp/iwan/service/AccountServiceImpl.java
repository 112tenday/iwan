package com.phincon.bootcamp.iwan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.phincon.bootcamp.iwan.model.Account;
import com.phincon.bootcamp.iwan.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Autowired
    AccountRepository repository;

    @Override
    public Account getAccountById(String id) {
        Account acc = repository.getAccountById(id);
        if (acc != null) {
            return acc;
        }
        return new Account();
    }


}






















