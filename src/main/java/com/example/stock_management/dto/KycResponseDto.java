package com.example.stock_management.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class KycResponseDto {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String nationality;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String phoneNumber;
    private String email;
    private KycStatusDTO kycStatus;

    @Data
    @Getter
    @Setter
    public static class KycStatusDTO{
        private String status;
        private LocalDateTime updatedAt;
    }
}
