package com.phincon.bootcamp.agung.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        // Inisialisasi objek Account sebelum setiap pengujian
        account = new Account();
    }

    @Test
    void testGetSetId() {
        // Set ID ke 1
        Long id = 1L;
        account.setId(id);

        // Pastikan getId() mengembalikan nilai yang diharapkan
        assertEquals(id, account.getId());
    }

    @Test
    void testGetSetType() {
        // Set tipe akun
        String type = "Savings";
        account.setType(type);

        // Pastikan getType() mengembalikan nilai yang diharapkan
        assertEquals(type, account.getType());
    }

    @Test
    void testGetSetCustomerId() {
        // Set ID pelanggan
        Long customerId = 100L;
        account.setCustomerId(customerId);

        // Pastikan getCustomerId() mengembalikan nilai yang diharapkan
        assertEquals(customerId, account.getCustomerId());
    }

    @Test
    void testGetSetAmount() {
        // Set jumlah
        Long amount = 5000L;
        account.setAmount(amount);

        // Pastikan getAmount() mengembalikan nilai yang diharapkan
        assertEquals(amount, account.getAmount());
    }

    @Test
    void testGetSetStatus() {
        // Set status
        Boolean status = true;
        account.setStatus(status);

        // Pastikan getStatus() mengembalikan nilai yang diharapkan
        assertEquals(status, account.getStatus());
    }

    @Test
    void testGetSetCreatedDate() {
        // Set tanggal dibuat
        Timestamp createdDate = mock(Timestamp.class);
        account.setCreatedDate(createdDate);

        // Pastikan getCreatedDate() mengembalikan nilai yang diharapkan
        assertEquals(createdDate, account.getCreatedDate());
    }

    @Test
    void testGetSetUpdatedDate() {
        // Set tanggal diperbarui
        Timestamp updatedDate = mock(Timestamp.class);
        account.setUpdatedDate(updatedDate);

        // Pastikan getUpdatedDate() mengembalikan nilai yang diharapkan
        assertEquals(updatedDate, account.getUpdatedDate());
    }
}
