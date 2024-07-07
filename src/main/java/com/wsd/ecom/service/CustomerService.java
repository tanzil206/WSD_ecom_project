package com.wsd.ecom.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wsd.ecom.entity.Customer;
import com.wsd.ecom.entity.Product;
import com.wsd.ecom.entity.WishList;
import com.wsd.ecom.exception.CustomerNotFoundException;
import com.wsd.ecom.repository.CustomerRepository;
import com.wsd.ecom.repository.WishListRepository;

import lombok.extern.slf4j.Slf4j;

import com.wsd.ecom.controller.SaleController;
import com.wsd.ecom.dto.WishListResponse;

@Service
public interface CustomerService {


	public Customer getCustomer(String userName) ;

	public WishListResponse getCustomerWishList(String userName) ;

		
}