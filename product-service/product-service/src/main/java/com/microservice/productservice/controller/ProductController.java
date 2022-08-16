package com.microservice.productservice.controller;

import com.microservice.productservice.model.Product;
import com.microservice.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAllProduct() {
        return ResponseEntity.ok(productService.findAllProduct());
    }

    @GetMapping("/findProductById/{id}")
    public ResponseEntity<Optional<Product>> findProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @GetMapping("/findProductByName/{name}")
    public ResponseEntity<List<Product>> findProductByName(@PathVariable String name){
        return ResponseEntity.ok(productService.findByProductName(name));
    }

}
