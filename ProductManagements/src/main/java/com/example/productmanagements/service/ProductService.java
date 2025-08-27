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
    public boolean update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public boolean deleteById(int id) {
        return productRepository.deleteById(id);
    }

    @Override
    public List<Product> searchByName(String keyword) {
        return productRepository.searchByName(keyword);
    }

    public List<Product> getProductsByPage(int page, int pageSize) {
        return productRepository.getProductsByPage(page, pageSize);
    }

    public int getTotalPages(int pageSize) {
        int totalProducts = productRepository.getTotalProducts();
        return (int) Math.ceil((double) totalProducts / pageSize);
    }

}
