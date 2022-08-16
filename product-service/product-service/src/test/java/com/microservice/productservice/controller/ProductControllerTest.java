package com.microservice.productservice.controller;

import com.microservice.productservice.model.Product;
import com.microservice.productservice.service.ProductService;
import com.netflix.discovery.converters.Auto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @Test
    void findAllProduct() {
        Product product = new Product();
        product.setProductName("test");

        List<Product> products = List.of(product);

        when(productService.findAllProduct()).thenReturn(products);
        ResponseEntity<List<Product>> result = productController.findAllProduct();

        assertEquals(result.getBody().size(),1);
    }

    @Test
    void findProductById(){
        Product product = new Product();
        product.setProductName("test");

        Optional<Product> productOption = Optional.of(product);

        when(productService.findProductById(0L)).thenReturn(productOption);
        ResponseEntity<Optional<Product>> result = productController.findProductById(0L);

        assertEquals(result.getBody().get().getProductName(),"test");

    }

    @Test
    void findProductByName(){
        Product product = new Product();
        product.setProductName("test");

        List<Product> products = List.of(product);

        when(productService.findByProductName("test")).thenReturn(products);
        ResponseEntity<List<Product>> result = productController.findProductByName("test");

        assertEquals(result.getBody().size(),1);
    }
}