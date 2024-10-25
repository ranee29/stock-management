package com.example.stock_management.dto;

import com.example.stock_management.entity.kyc.CustomerEntity;
import lombok.Data;

import java.util.Date;
@Data
public class KycDto {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
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
}
