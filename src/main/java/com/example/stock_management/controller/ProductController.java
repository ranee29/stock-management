package com.example.stock_management.controller;

import com.example.stock_management.entity.Categories;
import com.example.stock_management.entity.Products;
import com.example.stock_management.entity.PurchaseEntity;
import com.example.stock_management.entity.Suppliers;
import com.example.stock_management.repo.CategoriesRepo;
import com.example.stock_management.repo.ProductRepo;
import com.example.stock_management.repo.SuppliersRepo;
import com.example.stock_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoriesRepo categoryRepository;

    @Autowired
    private SuppliersRepo supplierRepository;

    @PostMapping("/")
    public ResponseEntity<Products> addProduct(@RequestBody Products products){
        // Retrieve category and supplier from the database
        Categories category = categoryRepository.findById(products.getCategory().getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        Suppliers supplier = supplierRepository.findById(products.getSupplier().getSupplierId())
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found"));
        productService.createProduct(products);
        return new ResponseEntity<Products>(products, HttpStatus.OK);
    }



    @GetMapping("/")
    public ResponseEntity<List<Products>> getAllProducts(){
        List<Products> products = null;
        try{
            products = productService.getProduct();
        }catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<List<Products>>(products, HttpStatus.OK);
    }
}
