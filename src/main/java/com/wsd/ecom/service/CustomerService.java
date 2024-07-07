package com.wsd.ecom.service;

import org.springframework.stereotype.Service;
import com.wsd.ecom.entity.Customer;
import com.wsd.ecom.dto.WishListResponse;

@Service
public interface CustomerService {

	public Customer getCustomer(String userName) ;

	public WishListResponse getCustomerWishList(String userName) ;

}