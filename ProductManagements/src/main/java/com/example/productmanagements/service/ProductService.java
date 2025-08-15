package com.example.productmanagements.service;

import com.example.productmanagements.enity.Product;
import com.example.productmanagements.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private ProductRepository productRepository = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean addProduct(Product product) {
        return productRepository.addProduct(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public boolean removeById(int id) {
        return productRepository.removeById(id);
    }
}
