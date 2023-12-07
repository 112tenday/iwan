package com.phincon.bootcamp.agung.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.phincon.bootcamp.agung.model.Customer;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Optional<Customer> getCustomerById(Long id);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Long id, Customer customer);

    void deleteCustomer(Long id);

    Customer patchCustomer(Long id, Map<String, Object> updates);
}