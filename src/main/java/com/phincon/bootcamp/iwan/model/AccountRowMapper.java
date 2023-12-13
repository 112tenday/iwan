package com.phincon.bootcamp.iwan.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet rs,int rowNum) throws SQLException{
        Account account = new Account();
        account.setId(rs.getString("id"));
        account.setAmount(rs.getLong("amount"));
        account.setCustomerId(rs.getString("customer_id"));
        account.setName(rs.getString("name"));
        account.setStatus(rs.getString("status"));
        account.setType(rs.getString("type"));
        account.setCreatedDate(rs.getTimestamp("createdDate"));
        return account;
    }


}
