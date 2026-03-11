package com.capg.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
