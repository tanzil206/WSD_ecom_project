package com.wsd.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wsd.ecom.entity.Product;
import com.wsd.ecom.exception.ProductNotFoundException;
import com.wsd.ecom.repository.ProductRepository;

@Service
public class ProductService {

	
	@Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }
}