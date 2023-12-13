package com.phincon.bootcamp.iwan.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.phincon.bootcamp.iwan.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
