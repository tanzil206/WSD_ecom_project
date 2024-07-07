package com.wsd.ecom.service;

import com.wsd.ecom.entity.Product;
import com.wsd.ecom.exception.ProductNotFoundException;
import com.wsd.ecom.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    void should_return_Product_details() {
        given(productRepository.findById(anyLong())).willReturn(java.util.Optional.of(new Product()));
        assertThat(productService.getProduct(1L)).isNotNull();
    }

    @Test
    void should_not_return_Product_details_if_not_present() {
        given(productRepository.findById(anyLong())).willThrow(ProductNotFoundException.class);
        assertThrows(ProductNotFoundException.class, () -> productService.getProduct(1L));
    }

}
