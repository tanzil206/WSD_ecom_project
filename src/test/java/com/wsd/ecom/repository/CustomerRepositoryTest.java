package com.wsd.ecom.repository;

import com.wsd.ecom.entity.Customer;

import net.bytebuddy.utility.dispatcher.JavaDispatcher.Container;

import org.assertj.core.api.Assertions;
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

import java.util.List;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {

	
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    @DisplayName("Test 1:Save Customer Test")
    @Order(1)
    @Rollback(value = false)
    public void saveCustomerTest(){

        //Action
        Customer customer = Customer.builder()
        		.id(1L)
                .userName("tanzir206")
                .customerName("Tanzir Ahamed")
                .build();

        customerRepository.save(customer);

        //Verify
       
        Assertions.assertThat(customer.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getCustomerTest(){

        //Action
        Customer Customer = customerRepository.findById(1L).get();
        //Verify
        System.out.println(Customer);
        Assertions.assertThat(Customer.getId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    public void getListOfCustomersTest(){
        //Action
        List<Customer> Customers = (List<Customer>) customerRepository.findAll();
        //Verify
        System.out.println(Customers);
        Assertions.assertThat(Customers.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateCustomerTest(){

        //Action
        Customer customer = customerRepository.findById(1L).get();
        customer.setCustomerName("Tanzil Ahmed");
        Customer customerUpdated =  customerRepository.save(customer);

        //Verify
        System.out.println(customerUpdated);
        Assertions.assertThat(customerUpdated.getCustomerName()).isEqualTo("Tanzil Ahmed");

    }



}
