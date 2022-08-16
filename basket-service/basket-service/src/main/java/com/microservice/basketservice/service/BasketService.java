package com.microservice.basketservice.service;

import com.microservice.basketservice.model.Basket;
import com.microservice.basketservice.repository.BasketRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Setter
public class BasketService {
    @Autowired
    private BasketRepository basketRepository;

    public Basket createBasket(Basket basket){
        return basketRepository.save(basket);
    }

    public List<Basket> findAllBasket(){
        return (List<Basket>) basketRepository.findAll();
    }

    public Optional<Basket> findById(Long id){
        return basketRepository.findById(id);
    }
}
