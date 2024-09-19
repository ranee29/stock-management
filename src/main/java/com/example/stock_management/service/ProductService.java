package com.example.stock_management.service;

import com.example.stock_management.entity.Categories;
import com.example.stock_management.entity.Products;
import com.example.stock_management.entity.PurchaseEntity;
import com.example.stock_management.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public Products createProduct(Products products){
        products.setDateAdded(LocalDateTime.now());
        products.setDateUpdated(LocalDateTime.now());
        return productRepo.save(products);
    }

    public List<Products> getProduct(){
        return (List<Products>)productRepo.findAll();
    }

    public Products getProductById(int id){
        return productRepo.findById(id).orElse(null);
    }
    public Products updateProductQuantity(PurchaseEntity purchaseEntity){
        Products productsDetails = getProductById(purchaseEntity.getProducts().getProductId());
        productsDetails.setStockQuantity(purchaseEntity.getQuantity() + productsDetails.getStockQuantity());
        return productRepo.save(productsDetails);
    }

//    public List<Products> getProductsByCategoryId(int id){
//        return productRepo.findByCategoryId(id);
//    }
}
