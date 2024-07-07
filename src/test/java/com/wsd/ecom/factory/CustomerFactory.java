package com.wsd.ecom.factory;

import com.wsd.ecom.entity.Customer;

public class CustomerFactory {

    public CustomerFactory() {
    }

    public static Customer Customer() {
        return new Customer(1L,"tanzir206", "Tanzir Ahamed");
    }
}