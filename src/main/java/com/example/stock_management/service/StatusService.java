package com.example.stock_management.service;

import com.example.stock_management.entity.StatusEntity;
import com.example.stock_management.repo.StatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StatusService {
    @Autowired
    private StatusRepo statusRepo;
    public Optional<StatusEntity> getStatusByName(String statusName) {
        return statusRepo.findByStatusName(statusName);
    }
}
