package com.example.stock_management.controller;

import com.example.stock_management.entity.Products;
import com.example.stock_management.entity.PurchaseEntity;
import com.example.stock_management.repo.PurchaseRepo;
import com.example.stock_management.service.ProductService;
import com.example.stock_management.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private ProductService productService;
    @PostMapping("/purchase")
    public ResponseEntity<PurchaseEntity> purchaseProduct(@RequestBody PurchaseEntity purchaseEntity){
        purchaseService.savePurchase(purchaseEntity);
        productService.updateProductQuantity(purchaseEntity);
        return new ResponseEntity<PurchaseEntity>(purchaseEntity, HttpStatus.OK);
    }
}
