package com.SpringJwtTurf.models.response;

import com.SpringJwtTurf.documents.User;

import java.time.LocalDate;

public class UserResponse {
    private String name;
    private String phoneNumber;
    private String gender;
    private LocalDate dateOfBirth;
    private String password;
    private String countryCode;
    private String emailId;
    private String displayImageUrl;
    private String role;

    public UserResponse(User user) {
        this.name = user.getNameOfUser();
        this.phoneNumber = user.getPhoneNumber();
        this.gender = user.getGender();
        this.dateOfBirth = user.getDateOfBirth();
        this.password = user.getPassword();
        this.countryCode = user.getCountryCode();
        this.emailId = user.getEmailId();
        this.displayImageUrl = user.getDisplayImageUrl();
        this.role = user.getRole();
    }
}
