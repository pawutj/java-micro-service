package com.microservice.basketservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
public class Product {

    private String productName;
    private int price;
}
