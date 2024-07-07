package com.wsd.ecom.service.impl;

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
import com.wsd.ecom.service.CustomerService;
import com.wsd.ecom.service.ProductService;

import lombok.extern.slf4j.Slf4j;
import com.wsd.ecom.dto.WishListResponse;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private WishListRepository wishListRepository;

    @Autowired
    ProductService productService;
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer getCustomer(String userName) {
		return customerRepository.findByUserName(userName).orElseThrow(CustomerNotFoundException::new);
	}

	@Override
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