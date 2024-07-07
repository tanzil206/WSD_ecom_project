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
@Slf4j
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private WishListRepository wishListRepository;

	@Autowired
	private ProductService productService;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer getCustomer(String userName) {
		return customerRepository.findByUserName(userName).orElseThrow(CustomerNotFoundException::new);
	}

	public WishListResponse getCustomerWishList(String userName) {

		WishListResponse wishListResponse = new WishListResponse();
		List<Product> productList = new ArrayList<>();
		try {
			Customer customer = getCustomer(userName);

			List<WishList> wishList = wishListRepository.findByCustomer(customer);

			/* Get customer username wise wished product info  */
			for (int i = 0; i < wishList.size(); i++) {

				Product product = productService.getProduct(wishList.get(i).getProduct().getId());
				productList.add(product);

			}
			wishListResponse.setUserName(userName); /* Create Response pattern with customer info and wished product info */
			wishListResponse.setCustomerName(customer.getCustomerName());
			wishListResponse.setProduct(productList);
		} catch (Exception ex) {
			log.error(ex.getMessage());
			return null;
		}

		return wishListResponse;
	}
}