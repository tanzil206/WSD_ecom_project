package com.wsd.ecom.controller;

import com.wsd.ecom.dto.WishListResponse;
import com.wsd.ecom.entity.Customer;
import com.wsd.ecom.exception.CustomerNotFoundException;
import com.wsd.ecom.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j

@RequestMapping("/api/customer")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService CustomerService) {
		this.customerService = CustomerService;
	}

	@GetMapping("/wishlist/{username}")
	public ResponseEntity<?> getCustomerWishList(@PathVariable String username) {

		WishListResponse wishListResponse = new WishListResponse();
		try {
			log.info("UserName : " +username);
			wishListResponse = customerService.getCustomerWishList(username);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
		}
		if(wishListResponse == null) {
			return new ResponseEntity<>("Message : Customer wishlist not found", HttpStatus.NOT_FOUND);	

		}else {
			return new ResponseEntity<>(wishListResponse, HttpStatus.OK);
		}
		

	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	private void CustomerNotFound(CustomerNotFoundException e) {
		log.error("Customer not found", e);
	}

}
