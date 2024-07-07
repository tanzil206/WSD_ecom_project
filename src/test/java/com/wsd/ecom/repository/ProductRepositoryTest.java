//package com.wsd.ecom.repository;
//
//import com.wsd.ecom.entity.Product;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import com.wsd.ecom.factory.ProductFactory;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//@AutoConfigureTestDatabase
//public class ProductRepositoryTest {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @BeforeEach
//    void setUp() {
//        productRepository.save(ProductFactory.Product());
//    }
//
//    @AfterEach
//    void tearDown() {
//        productRepository.deleteAll();
//    }
//
//    @Test
//    void should_return_Product_details() {
//        Optional<Product> product = productRepository.findById(1L);
//        assertThat(product.isPresent()).isTrue();
//        assertThat(product.get().getProductName()).isEqualTo("Beef");
//        assertThat(product.get().getCode()).isEqualTo("bf");
//        assertThat(product.get().getUnitPrice()).isEqualTo(700);
//        assertThat(product.get().getTotalStock()).isEqualTo(7);
//    }
//}
