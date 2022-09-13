package com.microservice.basketservice.service;

import com.microservice.basketservice.model.Basket;
import com.microservice.basketservice.repository.BasketRepository;
import com.microservice.basketservice.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mock;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class BasketServiceTest {

    @Mock
    BasketRepository basketRepository;

    @InjectMocks
    BasketService basketService;

    @Mock
    ItemRepository itemRepository;

    @Test
    void createBasket() {
        Basket basket = new Basket();
        basket.setUserId(0);
        when(basketRepository.save(basket)).thenReturn(basket);

        Basket result = basketService.createBasket(basket);

        assertEquals(result.getUserId(), 0);
    }

    @Test
    void addProductToUserIdById() throws Exception {
        Basket basket = new Basket();
        basket.setUserId(0);

        when(basketRepository.findByUserId(0L)).thenReturn(Optional.of(basket));


        basketService.addProductToUserIdById(0L, 0L, 3);
        basketService.addProductToUserIdById(1L, 0L, 3);
        Basket result = basketService.addProductToUserIdById(2L, 0L, 3);

        assertEquals(result.getItems().size(), 3);


    }
}