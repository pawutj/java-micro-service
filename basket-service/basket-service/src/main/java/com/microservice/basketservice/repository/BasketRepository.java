package com.microservice.basketservice.repository;

import com.microservice.basketservice.model.Basket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BasketRepository extends CrudRepository<Basket,Long> {
    Basket save(Basket basket);
    Optional<Basket> findById(Long id);
    void deleteById(Long id);
}
