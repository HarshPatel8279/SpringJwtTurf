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
public class CreateUserRequest {

    private String name;
    private String phoneNumber;
    private String gender;
    private LocalDate dateOfBirth;
    private String password;
    private String countryCode;
    private String emailId;
    private String displayImageUrl;
    private String role;



}
