package com.example.stock_management.service.user;

import com.example.stock_management.entity.user.UserEntity;
import com.example.stock_management.repo.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<UserEntity> getAllUsers(){
        return (List<UserEntity>)userRepo.findAll();
    }
}
