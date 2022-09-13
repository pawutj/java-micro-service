package com.microservice.basketservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long productId;
    private int quantity;

    @Transient
    private Product product;

    public Item(long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
