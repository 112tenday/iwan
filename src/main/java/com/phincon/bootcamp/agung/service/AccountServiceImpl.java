package com.phincon.bootcamp.agung.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.phincon.bootcamp.agung.model.Account;
import com.phincon.bootcamp.agung.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository repository;

    @Override
    public Account getAccount() {
        Account account = new Account();
        account.setId(1);
        account.setName("account1");
        account.setAmount(10.0);
        return account;
    }

    @Override
    public List<Account> getAccounts() {
        return (List<Account>) repository.findAll();
    }

    @Override
    public Account save(Account account) {
        return repository.save(account);

    }

    @Override
    public Account getAccountById(int id) {
        final Optional<Account> request = repository.findById(id);
        return request.orElse(null);
    }

}
