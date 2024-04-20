package com.springDataJpa.demospringjavajpa.repository;

import com.springDataJpa.demospringjavajpa.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
Optional<Product> findBySku(String sku);
}
