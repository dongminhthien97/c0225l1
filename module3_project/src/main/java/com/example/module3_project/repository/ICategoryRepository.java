package com.example.module3_project.repository;

import com.example.module3_project.model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();
    Category findById(int id);
}

