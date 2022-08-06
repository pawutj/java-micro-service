package com.microservice.productservice.service;

import com.microservice.productservice.model.Product;
import com.microservice.productservice.repository.ProductRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Setter
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> findProductById(Long id){
        Optional<Product> product = productRepository.findById(id);
        return product;
    }

    public List<Product> findByProductName(String productName){
        List<Product> products = productRepository.findByProductNameContaining(productName);
        return products;
    }

}
