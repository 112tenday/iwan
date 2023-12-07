package com.phincon.bootcamp.agung.service;

import java.util.List;
// import java.util.Map;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phincon.bootcamp.agung.model.Account;
import com.phincon.bootcamp.agung.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteCustomerById(id);
    }

    // @Override
    // public Account patchAccount(Long id, Map<String, Object> updates) {
    // Optional<Account> existingAccountOptional = accountRepository.findById(id);
    // if (existingAccountOptional.isPresent()) {
    // Account existingAccount = existingAccountOptional.get();

    // updates.forEach((key, value) -> {
    // switch (key) {
    // case "type":
    // existingAccount.setType((String) value);
    // break;
    // case "customerId":
    // existingAccount.setCustomerId((Long) value);
    // break;
    // case "amount":
    // existingAccount.setAmount((Long) value);
    // break;
    // case "status":
    // existingAccount.setStatus((Boolean) value);
    // break;

    // default:

    // break;
    // }
    // });

    // return accountRepository.save(existingAccount);
    // }
    // return null;
    // }
}