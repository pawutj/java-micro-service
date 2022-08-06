package com.microservice.productservice.repository;

import com.microservice.productservice.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
    List<Product> findByProductNameContaining(String name);
    Optional<Product> findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
}
