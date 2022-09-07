package com.microservice.basketservice.client;

import com.microservice.basketservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "product-service" , url = "http://localhost:8080/")
public interface ProductClient {

    @GetMapping("/products")
    List<Product> findAllProduct();

    @GetMapping("/products/findProductById/{id}")
    Optional<Product> findById(@PathVariable long id);

}
