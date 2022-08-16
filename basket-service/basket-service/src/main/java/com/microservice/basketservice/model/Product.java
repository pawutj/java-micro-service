package com.microservice.basketservice.model;

import lombok.Data;

@Data
public class Product {
    private long id;

    private String productName;
    private int price;
}
