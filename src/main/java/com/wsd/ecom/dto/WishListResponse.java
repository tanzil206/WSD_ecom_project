package com.wsd.ecom.dto;

import java.util.List;

import com.wsd.ecom.entity.Product;

public class WishListResponse {

	private String customerName;
	private String userName;
	private List<Product> product;

	public WishListResponse(String customerName, String userName, List<Product> product) {
		super();
		this.customerName = customerName;
		this.userName = userName;
		this.product = product;
	}

	public WishListResponse() {
		super();
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

}
