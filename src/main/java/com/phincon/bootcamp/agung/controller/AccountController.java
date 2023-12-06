package com.phincon.bootcamp.agung.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phincon.bootcamp.agung.model.Account;
import com.phincon.bootcamp.agung.service.AccountService;

@RestController
@RequestMapping("/test")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/bootcamp/account")
    public Account getAccount() {
        return accountService.getAccount();
    }

    @GetMapping("/bootcamp/accounts")
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @PostMapping("/bootcamp/account")
    public Account save(@RequestBody Map<String, Object> body) {
        Account account = new Account();
        account.setId((int) body.get("id"));
        account.setAmount((double) body.get("amount"));
        account.setName((String) body.get("name"));
        return accountService.save(account);
    }

    @GetMapping("/bootcamp/account/{id}")
    public Account getAccountById(@PathVariable int id) {
        return accountService.getAccountById(id);
    }
}
