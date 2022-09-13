package com.microservice.basketservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "baskets")
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long userId;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Item> items;

    public Basket() {
        this.items = new ArrayList<>();
    }

    public Basket(Long userId) {
        this.userId = userId;
        this.items = new ArrayList<>();
    }

}
