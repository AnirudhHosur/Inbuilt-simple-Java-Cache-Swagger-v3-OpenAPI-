package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.customer.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService cs;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestBody List<Customer> c) {
		return cs.addCustomer(c); 
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<Customer> get() {
		return cs.getAllCustomers();
	}
	
	@RequestMapping(value = "/update/{firstName}", method = RequestMethod.PUT)
	public String update(@RequestBody Customer c, @PathVariable("firstName") String firstName) {
		return cs.updateCustomer(firstName, c);
	}
	
	@RequestMapping(value = "/delete/{firstName}", method = RequestMethod.DELETE)
	public String add(@PathVariable String firstName) {
		return cs.deleteCustomer(firstName); 
	}
	
	@RequestMapping(value = "/get/{firstName}", method = RequestMethod.GET)
	public Customer getByName(@PathVariable("firstName") String firstName) {
		return cs.getCustomerByName(firstName);
	}
	
}
