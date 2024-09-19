package com.example.stock_management.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

@Entity
@Getter
@Setter
@Table(name = "suppliers")
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplierId;
    private String SupplierName;
    private String ContactName;
    private String ContactEmail;
    private String PhoneNumber;
    private String Address;
    private String City;
    private String Country;
//    @OneToMany(mappedBy = "SupplierID", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Suppliers> suppliersList = new ArrayList<>();
}
