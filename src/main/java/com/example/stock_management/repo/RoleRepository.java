package com.example.stock_management.repo;

import com.example.stock_management.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role , Integer> {
    Optional<Role> findByName(String name);
}
