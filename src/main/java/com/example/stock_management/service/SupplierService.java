package com.example.stock_management.service;

import com.example.stock_management.entity.Categories;
import com.example.stock_management.entity.Suppliers;
import com.example.stock_management.repo.SuppliersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SuppliersRepo suppliersRepo;

    public List<Suppliers> getAllSupplier(){
        return (List<Suppliers>)suppliersRepo.findAll();
    }
}
