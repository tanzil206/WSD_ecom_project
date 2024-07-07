package com.wsd.ecom.repository;

import com.wsd.ecom.entity.Sale;
import com.wsd.ecom.factory.SaleFactory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase
public class SaleRepositoryTest {

    @Autowired
    private SaleRepository saleRepository;

    @BeforeEach
    void setUp() {
        saleRepository.save(SaleFactory.Sale());
    }

    @AfterEach
    void tearDown() {
        saleRepository.deleteAll();
    }

    @Test
    void should_return_Sale_details() {
        Optional<Sale> sale = saleRepository.findById(1L);
        assertThat(sale.isPresent()).isTrue();
        assertThat(sale.get().getTotalPrice()).isEqualTo(700);
    }
}
