package com.example.stock_management.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "status")
public class StatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private Long statusId;

    @Column(name = "status_name", nullable = false, unique = true)
    private String statusName; // e.g., "Pending", "Approved", "Rejected"

    @Column(name = "description")
    private String description; // Additional details about the status

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
