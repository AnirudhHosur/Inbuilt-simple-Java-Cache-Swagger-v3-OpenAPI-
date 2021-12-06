package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.customer.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String>{


}
