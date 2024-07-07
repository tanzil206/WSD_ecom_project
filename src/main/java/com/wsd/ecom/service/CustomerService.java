package com.wsd.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wsd.ecom.entity.Customer;
import com.wsd.ecom.exception.CustomerNotFoundException;
import com.wsd.ecom.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductService productService;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer getCustomer(String userName) {
		return customerRepository.findByUserName(userName).orElseThrow(CustomerNotFoundException::new);
	}

}