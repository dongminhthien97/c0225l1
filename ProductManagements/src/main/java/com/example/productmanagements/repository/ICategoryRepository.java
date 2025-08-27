package com.example.productmanagements.repository;

import com.example.productmanagements.enity.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();
    Category findById(int id);
}
