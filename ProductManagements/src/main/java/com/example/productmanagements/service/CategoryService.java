package com.example.productmanagements.service;

import com.example.productmanagements.enity.Category;
import com.example.productmanagements.repository.CategoryRepository;

import java.util.List;

public class CategoryService implements ICategoryService{
    private final CategoryRepository categoryRepository = new CategoryRepository();
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id);
    }
}
