package com.microservice.productservice.service;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
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

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Optional<Product> deleteProductById(Long id){
        Optional<Product> oldProduct = productRepository.findById(id);
        if(oldProduct.isEmpty())
            return Optional.empty();

        productRepository.deleteById(id);

        return oldProduct;
    }

    public Optional<Product> findProductById(Long id){
        Optional<Product> product = productRepository.findById(id);
        return product;
    }

    public List<Product> findByProductName(String productName){
        List<Product> products = productRepository.findByProductNameContaining(productName);
        return products;
    }

    public Optional<Product> updateProductByProductId(Product product, Long id){
        Optional<Product> oldProduct = productRepository.findById(id);
        if(oldProduct.isEmpty())
            return Optional.empty();
        Product newProduct = oldProduct.get();
        newProduct.setProductName(product.getProductName());
        newProduct.setPrice(product.getPrice());

        Product result = productRepository.save(newProduct);
        return Optional.of(result);
    }

}
