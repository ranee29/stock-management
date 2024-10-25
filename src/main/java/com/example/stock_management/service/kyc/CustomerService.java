package com.example.stock_management.service.kyc;

import com.example.stock_management.entity.StatusEntity;
import com.example.stock_management.entity.kyc.CustomerEntity;
import com.example.stock_management.entity.kyc.KycStatus;
import com.example.stock_management.repo.kyc.CustomerRepository;
import com.example.stock_management.repo.kyc.KycStatusRepo;
import com.example.stock_management.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private KycStatusRepo kycStatusRepo;

    @Autowired
    private StatusService statusService;
    public CustomerEntity createCustomer(CustomerEntity customerEntity){
        CustomerEntity savedCustomer = customerRepository.save(customerEntity);
        StatusEntity status = statusService.getStatusByName("PENDING").get();
        KycStatus kycStatus = new KycStatus();
        kycStatus.setCustomer(savedCustomer); // Set the reference to the saved customer
        kycStatus.setStatus("PENDING"); // Set the initial status
        kycStatus.setUpdatedAt(LocalDateTime.now()); // Set the update time

        // Save the KYC status
        KycStatus savedKycStatus = kycStatusRepo.save(kycStatus);


        return savedCustomer;
    }

    private KycStatus createCustomerStatus(CustomerEntity customerEntity){
        KycStatus kycStatus = new KycStatus();
        kycStatus.setStatus("PENDING");
        kycStatus.setUpdatedAt(LocalDateTime.now());
        KycStatus kycStatusSaved = kycStatusRepo.save(kycStatus);
        return kycStatusSaved;
    }


    public Boolean checkCustomer(Long id){
        customerRepository.findById(id);
        if (customerRepository.findById(id).isPresent()){
            return true;
        }
        return false;
    }

    public CustomerEntity getCustomer(Long id){
        CustomerEntity savedCustomer =  customerRepository.findById(id).orElse(null);
        return savedCustomer;
    }


}
