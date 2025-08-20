package com.example.productmanagements.repository;

import com.example.productmanagements.enity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    boolean addProduct(Product product);
    Product findById(int id);
    boolean update(Product product);
    boolean deleteById(int id);
    List<Product> searchByName(String keyword);
}
