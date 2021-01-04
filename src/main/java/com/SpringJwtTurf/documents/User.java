package com.SpringJwtTurf.documents;

import com.SpringJwtTurf.models.common.Address;
import com.SpringJwtTurf.models.common.Location;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Getter
@Document
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    private Address address;
    private Location location;
    private Location latestLocation;


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

        this.address = user.getAddress();
        this.location = user.getLocation();
        this.latestLocation = user.getLatestLocation();
    }
}
