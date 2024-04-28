package com.springDataJpa.demospringjavajpa.controller;

import com.springDataJpa.demospringjavajpa.dto.ProductDTO;
import com.springDataJpa.demospringjavajpa.entity.Product;
import com.springDataJpa.demospringjavajpa.exception.ErrorDetails;
import com.springDataJpa.demospringjavajpa.exception.ResourceNotFoundExcecption;
import com.springDataJpa.demospringjavajpa.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
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

    //FilterAPI
//    @GetMapping("/search")
//    public ResponseEntity<List<ProductDTO>> searchProducts(@RequestParam("query") String query)
//    {
//        List<ProductDTO> searchResults = productService.searchProducts(query);
//        return ResponseEntity.ok(searchResults);
//    }

@GetMapping("/query")
    public ResponseEntity<List<Product>> getProductsByQuery(@RequestParam("description")String description)
{
    return ResponseEntity.ok(productService.findProductByDescription(description));
}
    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> searchProducts(
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "name", required = false) String name) {
        List<ProductDTO> searchResults = productService.searchProducts(description, name);
        return ResponseEntity.ok(searchResults);

}
//Count Total numbver of products
    @GetMapping("/count")
    public ResponseEntity<Long> getTotalProductCount() {
        long totalCount = productService.getTotalProductCount();
        return ResponseEntity.ok(totalCount);
    }
}
