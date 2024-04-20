package com.springDataJpa.demospringjavajpa.services;

import com.springDataJpa.demospringjavajpa.dto.ProductDTO;
import com.springDataJpa.demospringjavajpa.entity.Product;

import java.util.List;

public interface ProductService {
    ProductDTO addProduct(ProductDTO productDTO);
    ProductDTO getUserById(Long id);

    List<ProductDTO> getAllProdcts();

    //ProductDTO getAllProduct(List<Product>)
}
