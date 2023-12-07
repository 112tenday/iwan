package com.phincon.bootcamp.agung.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.phincon.bootcamp.agung.model.Account;

import jakarta.transaction.Transactional;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    @Query(value = "select*from Account", nativeQuery = true)
    List<Account> findAll();

    Account findById(Long accountId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM customer WHERE id = :id", nativeQuery = true)
    void deleteCustomerById(Long id);

}
