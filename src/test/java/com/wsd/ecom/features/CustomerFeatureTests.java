package com.wsd.ecom.features;

import com.wsd.ecom.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CustomerFeatureTests {

    @Autowired
    private TestRestTemplate customerApiEndPoint;

    @Test
    void api_should_return_Customer_wishList() {
        ResponseEntity<Customer> customer = customerApiEndPoint.getForEntity(
                "/api/customer/wishlist/tanzir206",
                Customer.class);
        assertThat(customer.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
