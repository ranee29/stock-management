package com.example.stock_management.repo;

import com.example.stock_management.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepo extends JpaRepository<StatusEntity, Long> {
    Optional<StatusEntity> findByStatusName(String statusName);
}
