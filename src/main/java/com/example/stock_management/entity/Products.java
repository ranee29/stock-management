package com.example.stock_management.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "product_information")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int ProductId;
    @Column(name = "product_name")
    private String ProductName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories category;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Suppliers supplier;

    @Column(name = "unit_price")
    private double UnitPrice;
    @Column(name = "stock_quantity")
    private int StockQuantity;
    @Column(name = "reorder_level")
    private int ReorderLevel;
    @Column(name = "date_added")
    private LocalDateTime DateAdded;
    private LocalDateTime dateUpdated;

}
