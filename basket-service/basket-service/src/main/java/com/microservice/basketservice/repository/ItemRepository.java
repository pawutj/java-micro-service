package com.microservice.basketservice.repository;

import com.microservice.basketservice.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ItemRepository extends CrudRepository<Item,Long> {
}
