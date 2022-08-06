package com.microservice.productservice.service;

import com.microservice.productservice.model.Product;
import com.microservice.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    void createProduct(){
        Product product = new Product();
        product.setProductName("test");

        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.createProduct(product);
        assertEquals(result.getProductName(),"test");
    }

    @Test
    void deleteProductByIdIfNull(){
        Product product = new Product();
        when(productRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Long id = 0L;
        Optional<Product> result = productService.deleteProductById(id);

        assertEquals(result,Optional.empty());
    }

    @Test
    void deleteProductById(){
        Product product = new Product();
        product.setProductName("test");
        when(productRepository.findById(Mockito.any())).thenReturn(Optional.of(product));
        Long id = 0L;
        Optional<Product> result = productService.deleteProductById(id);

        assertEquals(result.get().getProductName(),"test");
    }



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

    @Test
    void updateProductByProductIdIfNull(){
        Product product = new Product();
        when(productRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        Long id = 0L;
        Optional<Product> result = productService.updateProductByProductId(product,id);

        assertEquals(result,Optional.empty());
    }

    @Test
    void updateProductByProductId(){

        Product product = new Product();
        product.setProductName("test");
        Long id = 0L;
        when(productRepository.findById(id)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);
        Optional<Product> result = productService.updateProductByProductId(product,id);

        assertEquals(result.get().getProductName(),"test");
    }



}