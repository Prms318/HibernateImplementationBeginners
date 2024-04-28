package com.springDataJpa.demospringjavajpa.repository;

import com.springDataJpa.demospringjavajpa.dto.ProductDTO;
import com.springDataJpa.demospringjavajpa.entity.Product;

import org.junit.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
Optional<Product> findBySku(String sku);

//JPQL Using
//@Query("SELECT p FROM Product p WHERE p.sku LIKE CONCAT('%', :query, '%') AND p.description LIKE CONCAT('%', :query, '%')")
//List<Product> searchProducts(@Param("query") String query);
    public List<Product> findProductByDescription(String description);
    List<Product> findProductByDescriptionContainingAndNameContaining(String description, String name);

}
