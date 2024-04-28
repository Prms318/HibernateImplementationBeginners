package com.springDataJpa.demospringjavajpa.services;

import com.springDataJpa.demospringjavajpa.dto.ProductDTO;
import com.springDataJpa.demospringjavajpa.entity.Product;

import java.util.List;

public interface ProductService {
    ProductDTO addProduct(ProductDTO productDTO);
    ProductDTO getUserById(Long id);

    List<ProductDTO> getAllProdcts();

   // List<ProductDTO> searchProducts(String query);

  List<Product> findProductByDescription(String description);
    //ProductDTO getAllProduct(List<Product>)
    List<ProductDTO> searchProducts(String description, String name);
    long getTotalProductCount();
}
