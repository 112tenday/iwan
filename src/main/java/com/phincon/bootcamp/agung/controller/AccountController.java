package com.phincon.bootcamp.agung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.phincon.bootcamp.agung.model.Account;
import com.phincon.bootcamp.agung.service.AccountService;

import java.util.List;
// import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // GET /accounts
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    // GET /accounts/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok().body(account);
    }

    // POST /accounts
    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    // PUT /accounts/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account account) {
        Account updatedAccount = accountService.getAccountById(id);
        if (updatedAccount != null) {
            return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE /accounts/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // PATCH /accounts/{id}
    // @PatchMapping("/{id}")
    // public ResponseEntity<Account> patchAccount(@PathVariable Long id,
    // @RequestBody Map<String, Object> updates) {
    // Account patchedAccount = accountService.patchAccount(id, updates);
    // if (patchedAccount != null) {
    // return new ResponseEntity<>(patchedAccount, HttpStatus.OK);
    // }
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }
}