package com.wsd.ecom.repository;

import com.wsd.ecom.entity.Customer;

import com.wsd.ecom.factory.CustomerFactory;

import net.bytebuddy.utility.dispatcher.JavaDispatcher.Container;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Optional;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {

	
    @Autowired
    private CustomerRepository customerRepository;


    @BeforeEach
    void setUp() {
        customerRepository.save(CustomerFactory.Customer());
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void should_return_Customer_details() {
        Optional<Customer> customer = customerRepository.findById(1L);
        assertThat(customer.isPresent()).isTrue();
        assertThat(customer.get().getUserName()).isEqualTo("tanzir206");
        assertThat(customer.get().getCustomerName()).isEqualTo("Tanzir Ahamed");
    }

}

