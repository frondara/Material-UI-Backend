package com.frondara.materialuibackend.controllers;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id){
        HashMap<String, String> message = new HashMap();
		if(productService.existById(id)) {
			//Product task = productService.getTasksById(id).orElseThrow(() -> new EntityNotFoundException("Request Not Found"));
			productService.delete(id);
			message.put("message", id + " product removed");
			return ResponseEntity.status(HttpStatus.OK).body(message);
			
		}else {
			message.put("message", id + " product not found or matched");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
    }

    @PutMapping("product/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product productParam, @PathVariable Long id) {
        if(productService.existById(id)){
            Product product = productService.getTasksById(id).orElseThrow(() -> new EntityNotFoundException("Request Not Found"));
            product.setProductName(productParam.getProductName());
            product.setCategory(productParam.getCategory());
            product.setFreshness(productParam.getFreshness());
            product.setDate(productParam.getDate());
            product.setPrice(productParam.getPrice());
            product.setComment(productParam.getComment());
            productService.save(product);
            return ResponseEntity.ok().body(product);
        }else {
			HashMap<String, String> message = new HashMap();
			message.put("message", id + " product not found or matched");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
    }
}
