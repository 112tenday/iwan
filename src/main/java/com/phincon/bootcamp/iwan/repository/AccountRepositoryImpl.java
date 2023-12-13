package com.phincon.bootcamp.iwan.repository;

import com.phincon.bootcamp.iwan.model.AccountRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.phincon.bootcamp.iwan.model.Account;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

 Logger logger=LoggerFactory.getLogger(AccountRepositoryImpl.class);

    private static  final String INACTIVE ="inactive";

    @Autowired
    JdbcTemplate jdbcTemplate;
    public AccountRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account getAccountById(String id) {
        String sql = "SELECT * FROM ACCOUNTS WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new AccountRowMapper(),new Object[]{id});
    }

    @Override
    public Account getAccountByIdAndName(String id,String name) {
        String sql = "SELECT * FROM ACCOUNTS WHERE ID = ? AND NAME = ?";
        return jdbcTemplate.queryForObject(sql, new AccountRowMapper(), new Object[]{id,name});
    }

    @Override
    public Account create(Account account) {
        String  sql = "INSERT INTO ACCOUNTS(ID,CUSTOMER_ID,NAME,STATUS,TYPE,AMOUNT,CREATED_DATE) VALUES (?,?.?,?,?,?,?)";
                int  rowAffected =jdbcTemplate.update(sql,account.getId(),account.getCustomerId(),account.getName(),account.getStatus(),account.getType(), LocalDateTime.now(),account.getId());
                return account;
    }

    @Override
    public Account update(Account account) {
        String sql = "UPDATE ACCOUNTS SET CUSTOMER_ID=?,NAME=? ,STATUS=? ,TYPE=?, AMOUNT=? ,CREATED_DATE=? ";
        int  rowAffected =jdbcTemplate.update(sql,account.getCustomerId(),account.getName(),account.getStatus(),account.getType(), LocalDateTime.now(),account.getId());
        return account;
    }

    @Override
    public Account delete(String id) {
        String sql = "UPDATE ACCOUNTS SET STATUS=? WHERE ID=?";
        int rowAffected = jdbcTemplate.update(sql,
                INACTIVE,
                id);
        logger.info("success update {} for id {}", rowAffected, id);
        return getAccountById(id);
    }

    @Override
    public List<Account> getAll() {
        String sql = "SELECT * FROM ACCOUNTS";
        return jdbcTemplate.query(sql, new AccountRowMapper());

    }

}
