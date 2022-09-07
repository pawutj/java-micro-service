package com.microservice.basketservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int quantity;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToMany(mappedBy = "Item")
    private List<Basket> baskets;


}
