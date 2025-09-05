package com.example.module3_project.service;

import com.example.module3_project.model.Category;
import com.example.module3_project.repository.CategoryRepository;
import com.example.module3_project.repository.ICategoryRepository;

import java.util.List;

public class CategoryService implements ICategoryService {
    private final ICategoryRepository categoryRepository = new CategoryRepository();

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id);
    }
}
