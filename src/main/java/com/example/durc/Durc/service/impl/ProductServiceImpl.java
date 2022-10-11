package com.example.durc.Durc.service.impl;

import com.example.durc.Durc.model.Product;
import com.example.durc.Durc.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Product upate(Product product) {
        return null;
    }

    @Override
    public Optional<Product> getProductById(String id) {
        return Optional.empty();
    }


    @Override
    public void deleteById(String id) {

    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
