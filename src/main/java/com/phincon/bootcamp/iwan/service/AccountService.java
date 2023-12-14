package com.phincon.bootcamp.iwan.service;

import com.phincon.bootcamp.iwan.model.Account;

import java.util.List;

public interface AccountService {
    public Account getAccountById(String id);

    public Account getAccountByIdAndName(String id, String name);

    public Account create (Account account);

    public Account update (Account account);

    public Account delete (String id);

    public List<Account> getAll();



}