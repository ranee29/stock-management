package com.example.stock_management.service;

import com.example.stock_management.entity.Products;
import com.example.stock_management.entity.PurchaseEntity;
import com.example.stock_management.repo.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepo purchaseRepo;

    public PurchaseEntity savePurchase(PurchaseEntity purchaseEntity){
        purchaseEntity.setQuantity(purchaseEntity.getQuantity());
        purchaseEntity.setSuppliers(purchaseEntity.getProducts().getSupplier());
        purchaseEntity.setPurchaseDate(LocalDate.now());
        return purchaseRepo.save(purchaseEntity);
    }
}
