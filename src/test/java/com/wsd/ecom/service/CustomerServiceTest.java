package com.wsd.ecom.service;

import com.wsd.ecom.entity.Customer;
import com.wsd.ecom.exception.CustomerNotFoundException;
import com.wsd.ecom.repository.CustomerRepository;
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
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @MockBean
    private CustomerRepository customerRepository;

//    @Test
//    void should_return_Customer_details() {
//        given(customerRepository.findById(1L)).willReturn(java.util.Optional.of(new Customer()));
//        assertThat(customerService.getCustomer("tanzir206")).isNotNull();
//    }

    @Test
    void should_not_return_Customer_details_if_not_present() {
        given(customerRepository.findById(anyLong())).willThrow(CustomerNotFoundException.class);
        assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomer("tanzir207"));
    }

}
