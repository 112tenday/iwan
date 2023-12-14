package com.phincon.bootcamp.iwan.service;

import com.phincon.bootcamp.iwan.model.Account;
import com.phincon.bootcamp.iwan.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
        AccountRepository repository;

   AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public Account getAccountById(String id) {
        Account acc = repository.getAccountById(id);
        if (acc != null) {
            return acc;
        }
        return new Account();
    }

    @Override
    public Account getAccountByIdAndName(String id, String name) {
        logger.debug("getAccountByIdAndName id={} name={}", id,name);
        return repository.getAccountByIdAndName(id,name);
    }

    @Override
    public Account create(Account account) {
        account.setId(UUID.randomUUID().toString());
        logger.debug("create{}", account);
        return repository.create(account);
    }

    @Override
    public Account update(Account account) {
        logger.debug("update{}", account);

        return repository.update(account);
    }

    @Override
    public Account delete(String id) {
        logger.debug("delete id={}", id);
        return repository.delete(id);
    }

    @Override
    public List<Account> getAll() {
        List<Account>data = repository.getAll();
        logger.debug("getAll{}", data);
        return data ;
    }


}






















