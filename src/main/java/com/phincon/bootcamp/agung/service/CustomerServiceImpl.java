package com.phincon.bootcamp.agung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phincon.bootcamp.agung.model.Customer;
import com.phincon.bootcamp.agung.repository.CustomerRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {

    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {

    }

    @Override
    public Customer createCustomer(Customer customer) {

    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCustomer'");
    }

    @Override
    public void deleteCustomer(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCustomer'");
    }

    @Override
    public Customer patchCustomer(Long id, Map<String, Object> updates) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchCustomer'");
    }

}
