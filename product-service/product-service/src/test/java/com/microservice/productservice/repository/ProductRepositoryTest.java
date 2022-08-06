package com.microservice.productservice.repository;

import com.microservice.productservice.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByProductNameContaining(){
        Product product = new Product();
        product.setProductName("test");
        productRepository.save(product);
        List<Product> result = productRepository.findByProductNameContaining("test");
        assertTrue(result.size() ==1);
    }

    @Test
    void findById(){
        Product product = new Product();
        product.setProductName("test");
        Product response = productRepository.save(product);
        Optional<Product> result = productRepository.findById(response.getId());

        assertEquals(result.get().getProductName() , "test");
    }

    @Test
    void deleteById(){
        Product product = new Product();
        product.setProductName("test");

        Product response = productRepository.save(product);
        productRepository.deleteById(response.getId());

        Optional<Product> result = productRepository.findById(response.getId());
        assertEquals(result.isEmpty(), true);
    }

}