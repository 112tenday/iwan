package com.phincon.bootcamp.iwan.repository;

import com.phincon.bootcamp.iwan.model.AccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.phincon.bootcamp.iwan.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Account getAccountById(String id) {
        String sql = "SELECT * FROM ACCOUNTS WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new AccountRowMapper(), id);
    }

}
