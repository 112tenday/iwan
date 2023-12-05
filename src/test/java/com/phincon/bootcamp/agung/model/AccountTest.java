package com.phincon.bootcamp.agung.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AccountTest {

    public static Account account;

    @BeforeAll
    public static void setup() {
        account = new Account();
        account.setId(1);
        account.setName("agung");
        account.setAmount(10.0);
    }

    @Test
    void setId() {
        account.setId(1);
        assertTrue(true);
    }

    @Test
    void setName() {
    }

    @Test
    void setAmount() {
    }

    @Test
    void getId() {
        assertEquals(1, account.getId());
    }

    @Test
    void getName() {
        assertEquals("agung", account.getName());
    }

    @Test
    void getAmount() {
        assertEquals(10.0, account.getAmount());
    }
}
