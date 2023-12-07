package com.phincon.bootcamp.agung.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// import com.phincon.bootcamp.agung.controller.CustomerController;
import com.phincon.bootcamp.agung.model.Customer;
import com.phincon.bootcamp.agung.service.CustomerService;

@SpringBootTest
class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @Test
    void getAllCustomersTest() {
        // Arrange
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer());
        when(customerService.getAllCustomers()).thenReturn(customers);

        // Act
        ResponseEntity<List<Customer>> response = customerController.getAllCustomers();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customers, response.getBody());
    }

    @Test
    void getCustomerByIdTest() {
        // Arrange
        Long customerId = 1L;
        Customer customer = new Customer();
        when(customerService.getCustomerById(customerId)).thenReturn(Optional.of(customer));

        // Act
        ResponseEntity<Customer> response = customerController.getCustomerById(customerId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    void getCustomerByIdNotFoundTest() {
        // Arrange
        Long customerId = 1L;
        when(customerService.getCustomerById(customerId)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Customer> response = customerController.getCustomerById(customerId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void createCustomerTest() {
        // Arrange
        Customer customer = new Customer();
        when(customerService.createCustomer(customer)).thenReturn(customer);

        // Act
        ResponseEntity<Customer> response = customerController.createCustomer(customer);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    void updateCustomerTest() {
        // Arrange
        Long customerId = 1L;
        Customer customer = new Customer();
        when(customerService.updateCustomer(customerId, customer)).thenReturn(customer);

        // Act
        ResponseEntity<Customer> response = customerController.updateCustomer(customerId, customer);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    void updateCustomerNotFoundTest() {
        // Arrange
        Long customerId = 1L;
        when(customerService.updateCustomer(customerId, new Customer())).thenReturn(null);

        // Act
        ResponseEntity<Customer> response = customerController.updateCustomer(customerId, new Customer());

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void deleteCustomerTest() {
        // Arrange
        Long customerId = 1L;

        // Act
        ResponseEntity<Void> response = customerController.deleteCustomer(customerId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
        verify(customerService, times(1)).deleteCustomer(customerId);
    }

    @Test
    void patchCustomerTest() {
        // Arrange
        Long customerId = 1L;
        Customer patchedCustomer = new Customer();
        Map<String, Object> updates = new HashMap<>();
        updates.put("name", "New Name");

        when(customerService.patchCustomer(customerId, updates)).thenReturn(patchedCustomer);

        // Act
        ResponseEntity<Customer> response = customerController.patchCustomer(customerId, updates);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(patchedCustomer, response.getBody());
    }

    @Test
    void patchCustomerNotFoundTest() {
        // Arrange
        Long customerId = 1L;
        Map<String, Object> updates = new HashMap<>();
        updates.put("name", "New Name");

        when(customerService.patchCustomer(customerId, updates)).thenReturn(null);

        // Act
        ResponseEntity<Customer> response = customerController.patchCustomer(customerId, updates);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    // Add more tests for other controller methods as needed
}
