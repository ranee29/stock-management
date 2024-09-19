package com.example.stock_management.controller;

import com.example.stock_management.entity.Categories;
import com.example.stock_management.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoriesController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<Categories>> getAllCategories(){
        return new ResponseEntity<List<Categories>>(categoryService.getAllCategories(), HttpStatus.OK);
    }

}
