package com.example.stock_management.controller;

import com.example.stock_management.entity.Categories;
import com.example.stock_management.entity.Suppliers;
import com.example.stock_management.repo.SuppliersRepo;
import com.example.stock_management.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/")
    public ResponseEntity<List<Suppliers>> getAllCategories(){
        return new ResponseEntity<List<Suppliers>>(supplierService.getAllSupplier(), HttpStatus.OK);
    }
}
