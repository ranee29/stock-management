package com.example.stock_management.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "purchases")
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private int purchaseId;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products products;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Suppliers suppliers;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;
    @Column(name = "quantity_purchased")
    private int quantity;
    @Column(name = "unit_price")
    private double unitPrice;
    @Column(name = "total_cost")
    private double totalCost;


}
