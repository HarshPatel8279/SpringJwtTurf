package com.SpringJwtTurf.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Getter
@Document
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String _id;
    private String nameOfUser;
    private String username;
    private String firstName;
    private String middleName;
    private String lastName;
    private String password;
    private String gender;
    private LocalDate dateOfBirth;
    private String countryCode;
    private String phoneNumber;
    private String emailId;
    private String displayImageUrl;
    private String role;


    public User(User user) {
        this._id = user.get_id();
        this.nameOfUser = user.getNameOfUser();
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.middleName = user.getMiddleName();
        this.lastName = user.getLastName();
        this.password = user.getPassword();
        this.gender = user.getGender();
        this.dateOfBirth = user.getDateOfBirth();
        this.countryCode = user.getCountryCode();
        this.phoneNumber = user.getPhoneNumber();
        this.emailId = user.getEmailId();
        this.displayImageUrl = user.getDisplayImageUrl();
        this.role = user.getRole();
    }
}
