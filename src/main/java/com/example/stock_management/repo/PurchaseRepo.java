package com.example.stock_management.repo;

import com.example.stock_management.entity.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepo extends JpaRepository<PurchaseEntity, Integer> {
}
