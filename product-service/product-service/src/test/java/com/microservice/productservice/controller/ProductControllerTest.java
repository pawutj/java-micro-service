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
}