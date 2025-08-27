package com.example.productmanagements.service;

import com.example.productmanagements.enity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(int id);
}
