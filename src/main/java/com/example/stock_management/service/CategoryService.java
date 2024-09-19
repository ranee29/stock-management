package com.example.stock_management.service;

import com.example.stock_management.entity.Categories;
import com.example.stock_management.repo.CategoriesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoriesRepo categoriesRepo;

    public List<Categories> getAllCategories(){
        return (List<Categories>)categoriesRepo.findAll();
    }
}
