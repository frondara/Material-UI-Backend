package com.frondara.materialuibackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frondara.materialuibackend.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
