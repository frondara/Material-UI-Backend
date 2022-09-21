package com.frondara.materialuibackend.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
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

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Transactional
	public Optional<Product> getTasksById(Long id) {
		return productRepository.findById(id);
	}

    public boolean existById(Long id) {
        return productRepository.existsById(id);
    }


}
