package com.microservice.basketservice.client;

import com.microservice.basketservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/product")
    List<Product> findAllProduct();

}
