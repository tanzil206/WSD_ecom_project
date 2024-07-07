package com.wsd.ecom.controller;

import com.wsd.ecom.entity.Customer;
import com.wsd.ecom.exception.CustomerNotFoundException;
import com.wsd.ecom.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService CustomerService) {
		this.customerService = CustomerService;
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	private void CustomerNotFound(CustomerNotFoundException e) {
		log.error("Customer not found", e);
	}

}
