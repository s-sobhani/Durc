package com.example.durc.Durc.service;

import com.example.durc.Durc.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product save(Product product);

    Product upate(Product product);

    Optional<Product> getProductById(String id);

    void deleteById(String id);

    List<Product> findAll();
}
