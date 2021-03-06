package com.SpringJwtTurf.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerProfileUpdateRequest {

    private String name;
    private String phoneNumber;
    private String gender;
    private LocalDate dateOfBirth;
    private String password;
    private String countryCode;
    private String emailId;
    private String displayImageUrl;
    private String role;

    private  Double latitude;
    private Double longitude;
    private String addressLine;
    private String zipCode;
    private String city;
    private String state;

}
