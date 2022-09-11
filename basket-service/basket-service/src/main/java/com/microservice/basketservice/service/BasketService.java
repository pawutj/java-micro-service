package com.microservice.basketservice.service;

import com.microservice.basketservice.client.ProductClient;
import com.microservice.basketservice.model.Basket;
import com.microservice.basketservice.model.Item;
import com.microservice.basketservice.model.Product;
import com.microservice.basketservice.repository.BasketRepository;
import com.microservice.basketservice.repository.ItemRepository;
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

    @Autowired
    private ProductClient productClient;

    @Autowired
    private ItemRepository itemRepository;

    public Basket createBasket(Basket basket) {
        return basketRepository.save(basket);
    }

    public List<Basket> findAllBasket() {
        return (List<Basket>) basketRepository.findAll();
    }

    public Basket AddProductToUserIdById( long productId,long userId  , int quantity) throws Exception {
        Optional<Basket> basketOptional = basketRepository.findByUserId(userId);

        if(basketOptional.isPresent()){
            Item item = new Item(productId,quantity);
            Basket basket= basketOptional.get();
            List<Item> items = basket.getItems();
            items.add(item);
            return basket;
        }

        throw new Exception();
    }

}
