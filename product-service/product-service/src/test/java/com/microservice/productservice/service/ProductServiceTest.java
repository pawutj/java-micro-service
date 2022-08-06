package com.microservice.productservice.service;

import com.microservice.productservice.model.Product;
import com.microservice.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void findProductById() {
        Product product = new Product();
        product.setProductName("test12");
        Long id = 0L;

        when(productRepository.findById(id)).thenReturn(Optional.of(product));
        Optional<Product> result = productService.findProductById(id);

        assertEquals(result.isPresent() , true);
    }

    @Test
    void findByProductName() {
        Product product = new Product();
        product.setProductName("test12");

        when(productRepository.findByProductNameContaining("test")).thenReturn(List.of(product));
        List<Product> result = productService.findByProductName("test");

        assertEquals(result.size() , 1);
    }
}