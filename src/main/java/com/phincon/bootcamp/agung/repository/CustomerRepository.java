package com.phincon.bootcamp.agung.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.phincon.bootcamp.agung.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    // Jika ada metode tambahan khusus yang diperlukan, bisa ditambahkan di sini
}
