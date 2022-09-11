package com.microservice.basketservice.repository;

import com.microservice.basketservice.model.Basket;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BasketRepositoryTest {
    @Autowired
    private BasketRepository basketRepository;

    @Test
    void save() {
        Basket basket = new Basket();
            Basket res = basketRepository.save(basket);

        Optional<Basket> result = basketRepository.findById(res.getId());

        assertEquals(result.isPresent(), true);
    }

    @Test
    void findByUserId(){
        Basket basket = new Basket(10L);
        Basket res = basketRepository.save(basket);

        Optional<Basket> result = basketRepository.findByUserId(10L);
        assertEquals(result.isPresent(), true);

    }

}