package com.phincon.bootcamp.iwan.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountTest {

    @Test
    void testGetterAndSetter() {
        // Given
        String customerId = "1234";
        String id = "01";
        String name = "Iwan";
        String type = "Test";
        String status = "Active";
        Long amount = 1000L;
        long currentTime = System.currentTimeMillis();
        Timestamp createdDate = new Timestamp(currentTime);
        Timestamp updateDate = new Timestamp(currentTime);

        // When
        Account account = new Account();
        account.setCustomerId(customerId);
        account.setId(id);
        account.setName(name);
        account.setType(type);
        account.setStatus(status);
        account.setAmount(amount);
        account.setCreatedDate(createdDate);
        account.setUpdateDate(updateDate);

        // Then
        assertEquals("1234", account.getCustomerId());
        assertEquals(id, account.getId());
        assertEquals(name, account.getName());
        assertEquals(type, account.getType());
        assertEquals(status, account.getStatus());
        assertEquals(amount, account.getAmount());
        assertEquals(createdDate, account.getCreatedDate());
        assertEquals(updateDate, account.getUpdateDate());
    }

}
