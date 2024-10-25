package com.example.stock_management.repo.kyc;

import com.example.stock_management.entity.kyc.CustomerEntity;
import com.example.stock_management.entity.kyc.KycStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KycStatusRepo extends JpaRepository<KycStatus, Long> {
}
