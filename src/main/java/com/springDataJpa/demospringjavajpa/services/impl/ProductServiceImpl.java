package com.springDataJpa.demospringjavajpa.services.impl;

import com.springDataJpa.demospringjavajpa.dto.ProductDTO;
import com.springDataJpa.demospringjavajpa.entity.Product;
import com.springDataJpa.demospringjavajpa.exception.ResourceNotFoundExcecption;
import com.springDataJpa.demospringjavajpa.exception.SameSKUAlredyExists;
import com.springDataJpa.demospringjavajpa.repository.ProductRepository;
import com.springDataJpa.demospringjavajpa.services.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    @Override
    public ProductDTO addProduct( ProductDTO productDTO) {
        Optional<Product> sameSku=productRepository.findBySku(productDTO.getSku());
        if (sameSku.isPresent()){
            throw new SameSKUAlredyExists("Same SKU Already Exists please use different SKU");
        }
     Product product = modelMapper.map(productDTO,Product.class);
        Product savedProduct= productRepository.save(product);


        return modelMapper.map(savedProduct, ProductDTO.class);
    }

    @Override
    public ProductDTO getUserById(Long id) {
    Product product=  productRepository.findById(id).orElseThrow(
            ()->new ResourceNotFoundExcecption("Product","id",id)
    );
        //Optional<Product> product=productRepository.findById(id).orElseThrow()
      return  modelMapper.map(product,ProductDTO.class);
       // return null;
    }

    @Override
    public List<ProductDTO> getAllProdcts() {
       List<Product> productsLists= productRepository.findAll();

        return productsLists.stream().map((product)->modelMapper.map(product,ProductDTO.class))
                .collect(Collectors.toList());
    }
}
