package com.phincon.bootcamp.agung.repository;

import org.springframework.data.repository.CrudRepository;
import com.phincon.bootcamp.agung.model.Account;

public interface AccountRepository extends CrudRepository<Account, String> {

}
