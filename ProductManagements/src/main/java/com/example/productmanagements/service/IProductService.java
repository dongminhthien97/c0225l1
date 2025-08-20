package com.example.productmanagements.service;

import com.example.productmanagements.enity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    boolean addProduct(Product product);
    Product findById(int id);
    boolean update(Product product);
    boolean deleteById(int id);
    List<Product> searchByName(String keyword);
}
