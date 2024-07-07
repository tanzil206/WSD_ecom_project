package com.wsd.ecom.factory;

import com.wsd.ecom.entity.Product;

public class ProductFactory {

    public ProductFactory() {
    }

    public static Product Product() {
        return new Product(1L, "Salt","salt-500",20,20);
    }
}