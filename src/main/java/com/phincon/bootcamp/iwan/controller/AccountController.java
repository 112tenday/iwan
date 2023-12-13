package com.phincon.bootcamp.iwan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.phincon.bootcamp.iwan.model.Account;
import com.phincon.bootcamp.iwan.service.AccountService;

@RestController
public class AccountController {
    Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;

    @GetMapping ("/bootcamp/account/{id}")
    public Account getAccount(@PathVariable String id){
        logger.info("getAccount id {}",id);
        return accountService.getAccountById(id);
    }


    }
