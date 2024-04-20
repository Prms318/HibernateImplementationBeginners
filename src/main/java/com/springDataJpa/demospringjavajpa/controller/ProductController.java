package com.springDataJpa.demospringjavajpa.controller;

import com.springDataJpa.demospringjavajpa.dto.ProductDTO;
import com.springDataJpa.demospringjavajpa.entity.Product;
import com.springDataJpa.demospringjavajpa.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/ecommerce")
@AllArgsConstructor

public class ProductController {
    private ProductService productService;
    //Building the RESTAPI
    @PostMapping("/add")
    public ResponseEntity<ProductDTO>addProduct(@RequestBody ProductDTO productDTO){
        ProductDTO savedProduct=productService.addProduct(productDTO);
        return  new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    //Get Prodcut API
    @GetMapping("{id}")
    public  ResponseEntity<ProductDTO>getUserById(@PathVariable("id") Long productId){
     ProductDTO productDTO= productService.getUserById(productId);
     return new ResponseEntity<>(productDTO,HttpStatus.OK);
    }

    //Get All Products
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        List<ProductDTO> productList=productService.getAllProdcts();
        return ResponseEntity.ok(productList);
    }
}