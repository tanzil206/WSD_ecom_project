package com.wsd.ecom.factory;

import java.util.Date;

import com.wsd.ecom.entity.Product;
import com.wsd.ecom.entity.Sale;

public class SaleFactory {

    public SaleFactory() {
    }

    public static Sale Sale() {
        return new Sale(1L, new Product(),1, 700, new Date("2024-07-06"));
    }
}