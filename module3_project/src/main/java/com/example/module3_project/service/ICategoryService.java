package com.example.module3_project.service;

import com.example.module3_project.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(int id);
}
