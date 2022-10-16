package com.example.durc.Durc.controller;


import com.example.durc.Durc.model.Product;
import com.example.durc.Durc.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products/")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @PostMapping
    public Product saveProduct(Product product){

        return productService.save(product);
    }

    @PutMapping
    public Product updateProduct(Product product){

        return productService.upate(product);
    }

    @GetMapping("/{id}")
    public Optional<Product> findById(String id){

        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> findAll(){

        return productService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteByID(String id){

        productService.deleteById(id);
    }
}
