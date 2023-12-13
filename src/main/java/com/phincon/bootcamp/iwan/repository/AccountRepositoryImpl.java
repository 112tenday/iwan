package com.phincon.bootcamp.agung.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.phincon.bootcamp.agung.model.Account;

public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Account getAccountById(String id) {
        String sql = "SELECT * FROM ACCOUNTS WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, Account.class, id);
    }

}
