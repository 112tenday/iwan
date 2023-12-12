package com.phincon.bootcamp.iwan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.phincon.bootcamp.iwan.model.Account;
import com.phincon.bootcamp.iwan.model.AccountDto;
import com.phincon.bootcamp.iwan.repository.AccountRepository;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getAccount(String id) {
        // Mengambil akun berdasarkan ID
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public List<Account> getAccounts() {
        // Mengambil semua akun
        return (List<Account>) accountRepository.findAll();
    }

    @Override
    public Account save(AccountDto accountDto) {
        // Membuat dan menyimpan akun baru
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setAmount(accountDto.getAmount());
        account.setName(accountDto.getName());
        account.setCustomerId(accountDto.getCustomerId());
        account.setType(accountDto.getType());

        return accountRepository.save(account);
    }

    @Override
    public Account patch(AccountDto accountDto) {
        // Mengimplementasikan logika patch akun
        // (contoh: Anda dapat menggabungkan logika patch dengan update)
        Account existingAccount = accountRepository.findById(accountDto.getId()).orElse(null);
        if (existingAccount != null) {
            existingAccount.setName(accountDto.getName());
            // Implementasikan logika patch lainnya yang dibutuhkan
            return accountRepository.save(existingAccount);
        }
        return null;
    }

    @Override
    public Account update(AccountDto accountDto) {
        // Mengimplementasikan logika update akun
        Account existingAccount = accountRepository.findById(accountDto.getId()).orElse(null);
        if (existingAccount != null) {
            existingAccount.setName(accountDto.getName());
            existingAccount.setAmount(accountDto.getAmount());
            // Implementasikan logika update lainnya yang dibutuhkan
            return accountRepository.save(existingAccount);
        }
        return null;
    }

    @Override
    public Account delete(String id) {
        // Mengimplementasikan logika delete akun
        accountRepository.deleteById(id);
        return null;
    }
}