package com.wsd.ecom.repository;

import com.wsd.ecom.entity.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import com.wsd.ecom.factory.CustomerFactory;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureMockMvc
public class CustomerRepositoryTest {

    @Mock
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
