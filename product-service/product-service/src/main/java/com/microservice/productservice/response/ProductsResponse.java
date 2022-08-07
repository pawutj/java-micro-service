package com.microservice.productservice.response;

import com.microservice.productservice.model.Product;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class ProductsResponse {
    private List<Product> products;


}
