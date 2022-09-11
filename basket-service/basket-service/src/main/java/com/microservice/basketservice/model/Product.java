package com.microservice.basketservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name  = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;

    @Transient
    private long id;

    private String productName;
    private int price;
}
