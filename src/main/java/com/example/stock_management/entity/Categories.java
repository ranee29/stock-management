package com.example.stock_management.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categories")
@Getter
@Setter
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "Description")
    private String Description;

//    @OneToMany(mappedBy = "CategoryID", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Products> productsList = new ArrayList<>();

}
