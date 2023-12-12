package com.phincon.bootcamp.iwan.repository;

import org.springframework.data.repository.CrudRepository;
import com.phincon.bootcamp.iwan.model.Account;

public interface AccountRepository extends CrudRepository<Account, String> {

}