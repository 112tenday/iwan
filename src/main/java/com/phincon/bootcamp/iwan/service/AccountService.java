package com.phincon.bootcamp.iwan.service;

import java.util.List;
// import java.util.Map;

import com.phincon.bootcamp.iwan.model.Account;
import com.phincon.bootcamp.iwan.model.AccountDto;

public interface AccountService {
    public Account getAccount(String id);

    public List<Account> getAccounts();

    public Account save(AccountDto accountDto);

    public Account patch(AccountDto accountDto);

    public Account update(AccountDto accountDto);

    public Account delete(String id);

}