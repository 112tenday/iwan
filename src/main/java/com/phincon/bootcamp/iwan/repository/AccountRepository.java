package com.phincon.bootcamp.iwan.repository;

import com.phincon.bootcamp.iwan.model.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository {

    public Account getAccountById(String id);

    public Account getAccountByIdAndName(String id, String name);

    public Account create (Account account);

    public Account update (Account account);

    public Account delete (String id);

    public List<Account> getAll();


}
