package com.phincon.bootcamp.agung.service;

import java.util.List;
// import java.util.Map;

import com.phincon.bootcamp.agung.model.Account;

public interface AccountService {
    List<Account> getAllAccounts();

    Account getAccountById(Long id);

    Account createAccount(Account account);

    Account updateAccount(Account account);

    void deleteAccount(Long id);

    // Account patchAccount(Long id, Map<String, Object> updates);
}