package com.frondara.materialuibackend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frondara.materialuibackend.entity.Product;
import com.frondara.materialuibackend.services.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
@AllArgsConstructor
public class ProductController {
    
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping("product")
    public Product addProduct(@RequestBody Product product){
        return productService.save(product);
    }
}
