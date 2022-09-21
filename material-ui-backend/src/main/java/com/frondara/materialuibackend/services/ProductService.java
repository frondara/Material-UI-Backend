package com.frondara.materialuibackend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.frondara.materialuibackend.entity.Product;
import com.frondara.materialuibackend.repositories.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.saveAndFlush(product);
    }


}
