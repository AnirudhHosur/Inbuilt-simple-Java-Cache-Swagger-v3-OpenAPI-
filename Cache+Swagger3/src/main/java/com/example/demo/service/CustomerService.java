package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.customer.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
@Component
@CacheConfig(cacheNames = {"CUSTOMERS"})
public class CustomerService {
	private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
	@Autowired
	CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers() {
		List<Customer> allCusts = new ArrayList<Customer>();
		customerRepository.findAll().forEach(c -> allCusts.add(c));
		return allCusts;
	}

	public String addCustomer(List<Customer> customers) {
		logger.info("adding customer with id");
		customerRepository.saveAll(customers);
		return "Customer Added :)";
	}
	
	@CacheEvict(key="#customer.firstName")
	public String updateCustomer(String firstName, Customer customer) {
		Customer c = customerRepository.findById(firstName).orElse(null);
		if (c != null) {
			customerRepository.save(customer);
			logger.info("Customer updated :D");
			return "Customer Updated :)";
		}
		return "No such customer exists";
	}
	
	@CacheEvict(key="#customer.firstName")
	public String deleteCustomer(String firstName) {
		customerRepository.deleteById(firstName);
		logger.info("Customer deleted with id - {}", firstName);
		return "Customer Deleted :)";
	}

	@Cacheable(unless="#result==null")
	public Customer getCustomerByName(String firstName) {
		logger.info("fetching customer from db with id - {}", firstName);
		Customer c = customerRepository.findById(firstName).orElse(null);
		return c;
	}
	
	@Caching(evict = {
			@CacheEvict(value="CUSTOMERS", allEntries=true)
	})
	public void clearAllCache() {
		logger.info("CLeared all cache");
	}
}
