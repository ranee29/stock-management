package com.example.stock_management.controller.kyc;

import com.example.stock_management.dto.KycDto;
import com.example.stock_management.dto.KycResponseDto;
import com.example.stock_management.entity.kyc.CustomerEntity;
import com.example.stock_management.service.kyc.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kyc")
public class KycControntroller {
    @Autowired
    private CustomerService customerService;
    @PreAuthorize("hasRole('LOAN-PROCESSOR')")
    @PostMapping
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customerEntity){
        CustomerEntity sampleCustomer =  customerService.createCustomer(customerEntity);

        return new ResponseEntity<>(sampleCustomer ,HttpStatus.OK);
    }

    @PreAuthorize("hasRole('LOAN-PROCESSOR')")
    @GetMapping("/{id}")
    public ResponseEntity<KycResponseDto> getCustomer(@PathVariable("id") Long id){
        if(customerService.checkCustomer(id) == true){
            CustomerEntity customer = customerService.getCustomer(id);
            KycResponseDto responseDto = new KycResponseDto();
            if (customer != null) {

                responseDto.setCustomerId(customer.getCustomerId());
                responseDto.setFirstName(customer.getFirstName());
                responseDto.setLastName(customer.getLastName());
                responseDto.setDateOfBirth(customer.getDateOfBirth().toString()); // Format as needed
                responseDto.setGender(customer.getGender());
                responseDto.setNationality(customer.getNationality());
                responseDto.setAddressLine1(customer.getAddressLine1());
                responseDto.setAddressLine2(customer.getAddressLine2());
                responseDto.setCity(customer.getCity());
                responseDto.setState(customer.getState());
                responseDto.setPostalCode(customer.getPostalCode());
                responseDto.setCountry(customer.getCountry());
                responseDto.setPhoneNumber(customer.getPhoneNumber());
                responseDto.setEmail(customer.getEmail());
                if (customer.getKycStatus() != null) {
                    KycResponseDto.KycStatusDTO kycStatusDTO = new KycResponseDto.KycStatusDTO();
                    kycStatusDTO.setStatus(customer.getKycStatus().getStatus());
                    kycStatusDTO.setUpdatedAt(customer.getKycStatus().getUpdatedAt());
                    responseDto.setKycStatus(kycStatusDTO);
                }
                return new ResponseEntity<>(responseDto,HttpStatus.OK);
                }
            }
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

}
