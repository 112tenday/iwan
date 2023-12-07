package com.phincon.bootcamp.iwan.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void testCustomerCreation() {
        // Membuat objek Customer untuk diuji
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("John Doe");
        customer.setAge(25);
        customer.setStatus(true);

        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        customer.setCreatedDate(currentTimestamp);

        // Melakukan pengujian menggunakan assertions
        assertEquals(1L, customer.getId());
        assertEquals("John Doe", customer.getName());
        assertEquals(25, customer.getAge());
        assertEquals(true, customer.isStatus());
        assertEquals(currentTimestamp, customer.getCreatedDate());

        // Anda juga dapat menambahkan pengujian untuk updatedDate jika diperlukan
    }

    @Test
    public void testGetUpdatedDate() {
        // Membuat objek Customer untuk diuji
        Customer customer = new Customer();

        // Melakukan pengujian bahwa updatedDate awalnya null
        assertNull(customer.getUpdatedDate());

        // Set updatedDate dengan nilai tertentu
        Timestamp updatedTimestamp = new Timestamp(System.currentTimeMillis());
        customer.setUpdatedDate(updatedTimestamp);

        // Melakukan pengujian bahwa getUpdatedDate mengembalikan nilai yang diharapkan
        assertEquals(updatedTimestamp, customer.getUpdatedDate());
    }
}
