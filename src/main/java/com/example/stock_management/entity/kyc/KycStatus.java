package com.example.stock_management.entity.kyc;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@Table(name = "kyc_status")
public class KycStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Long statusId;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private CustomerEntity customer;  // Reference to the Customer entity

    @Column(name = "kyc_status", nullable = false)
    private String status;  // e.g., Pending, Verified, Rejected

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
