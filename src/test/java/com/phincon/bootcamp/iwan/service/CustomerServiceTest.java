package com.phincon.bootcamp.iwan.service;

import com.phincon.bootcamp.iwan.model.Customer;
import com.phincon.bootcamp.iwan.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    public void testUpdateCustomerWhenCustomerExists() {
        Customer existingCustomer = new Customer();
        existingCustomer.setId(String.valueOf(1L));
        existingCustomer.setName("John Doe");

        Mockito.when(customerRepository.existsById(anyLong())).thenReturn(true);
        Mockito.when(customerRepository.save(any(Customer.class))).thenReturn(existingCustomer);

        Customer updatedCustomer = customerService.updateCustomer(1L, existingCustomer);

        assertThat(updatedCustomer).isNotNull();
        assertThat(updatedCustomer.getId()).isEqualTo(existingCustomer.getId());
        assertThat(updatedCustomer.getName()).isEqualTo(existingCustomer.getName());

    }

    @Test
    public void testUpdateCustomerWhenCustomerNotExists() {
        Customer nonExistingCustomer = new Customer();
        nonExistingCustomer.setId("35");
        nonExistingCustomer.setName("Jane Doe");


        Mockito.when(customerRepository.existsById(anyLong())).thenReturn(false);

        Customer updatedCustomer = customerService.updateCustomer(2L, nonExistingCustomer);

        assertThat(updatedCustomer).isNull();
    }

    @Test
    public void testPatchCustomer() {
        Customer existingCustomer = new Customer();
        existingCustomer.setId("25");
        existingCustomer.setName("John Doe");


        Map<String, Object> updates = new HashMap<>();
        updates.put("name", "John Updated");
        updates.put("age", 35);

        Mockito.when(customerRepository.findById(anyLong())).thenReturn(Optional.of(existingCustomer));
        Mockito.when(customerRepository.save(any(Customer.class))).thenReturn(existingCustomer);

        Customer patchedCustomer = customerService.patchCustomer(1L, updates);

        assertThat(patchedCustomer).isNotNull();
        assertThat(patchedCustomer.getId()).isEqualTo(existingCustomer.getId());
        assertThat(patchedCustomer.getName()).isEqualTo("John Updated");

    }

    @Test
    public void testGetAllCustomers() {
        Customer customer1 = new Customer();
        customer1.setId("25");
        Customer customer2 = new Customer();
        customer2.setId("25");

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);

        Mockito.when(customerRepository.findAll()).thenReturn(customerList);

        List<Customer> fetchedCustomers = customerService.getAllCustomers();

        assertThat(fetchedCustomers).isNotNull();
        assertThat(fetchedCustomers.size()).isEqualTo(2);
        assertThat(fetchedCustomers.get(0).getId()).isEqualTo(1L);
        assertThat(fetchedCustomers.get(1).getId()).isEqualTo(2L);
    }

    @Test
    public void testGetCustomerById() {
        Customer customer = new Customer();
        customer.setId("25");

        Mockito.when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));

        Optional<Customer> fetchedCustomer = customerService.getCustomerById(1L);

        assertThat(fetchedCustomer).isPresent();
        assertThat(fetchedCustomer.get().getId()).isEqualTo(1L);
    }

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setId("25");

        Mockito.when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        Customer createdCustomer = customerService.createCustomer(customer);

        assertThat(createdCustomer).isNotNull();
        assertThat(createdCustomer.getId()).isEqualTo(1L);
    }

    @Test
    public void testDeleteCustomer() {
        // Nothing to assert for deleteCustomer() method, as it doesn't return a value.
        Mockito.doNothing().when(customerRepository).deleteById(anyLong());
        customerService.deleteCustomer(1L);
    }

    @Test
    void patchCustomerWhenCustomerNotFoundTest() {
        // Arrange
        Long customerId = 1L;
        Map<String, Object> updates = new HashMap<>();
        updates.put("name", "New Name");
        when(customerRepository.findById(customerId)).thenReturn(Optional.empty());

        // Act
        Customer result = customerService.patchCustomer(customerId, updates);

        // Assert
        assertNull(result);
        verify(customerRepository, never()).save(any());
    }

    @Test
    void patchCustomerWhenCustomerFoundTest() {
        // Arrange
        Long customerId = 1L;
        Map<String, Object> updates = new HashMap<>();
        updates.put("name", "New Name");

        Customer existingCustomer = new Customer();
        existingCustomer.setId(String.valueOf(customerId));
        when(customerRepository.findById(customerId)).thenReturn(Optional.of(existingCustomer));
        when(customerRepository.save(existingCustomer)).thenReturn(existingCustomer);

        // Act
        Customer result = customerService.patchCustomer(customerId, updates);

        // Assert
        assertNotNull(result);
        assertEquals("New Name", result.getName());
        verify(customerRepository, times(1)).save(existingCustomer);
    }

    // Add more tests for other update cases as needed

}