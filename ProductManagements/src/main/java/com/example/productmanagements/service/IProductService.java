package com.example.productmanagements.service;

import com.example.productmanagements.enity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    boolean addProduct(Product product);
    Product findById(int id);
    void update(Product product);
    boolean removeById(int id);
}
