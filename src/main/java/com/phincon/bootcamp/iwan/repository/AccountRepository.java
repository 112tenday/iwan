package com.phincon.bootcamp.iwan.repository;

import com.phincon.bootcamp.iwan.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository {

    public Account getAccountById(String id);
}
