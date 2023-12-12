package com.phincon.bootcamp.iwan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.phincon.bootcamp.iwan.model.Customer;
import com.phincon.bootcamp.iwan.repository.CustomerRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        // Implement the logic to update a customer
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer existingCustomer = optionalCustomer.get();
            existingCustomer.setName(customer.getName());
            existingCustomer.setStatus(customer.getStatus());
            existingCustomer.setCreatedDate(customer.getCreatedDate());
            // Set other fields as needed
            return customerRepository.save(existingCustomer);
        }
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer patchCustomer(Long id, Map<String, Object> updates) {
        // Implement the logic to patch a customer
        return null;
    }
}
