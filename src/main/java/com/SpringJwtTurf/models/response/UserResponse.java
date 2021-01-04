package com.SpringJwtTurf.models.response;

import com.SpringJwtTurf.documents.User;
import com.SpringJwtTurf.models.common.Address;
import com.SpringJwtTurf.models.common.Location;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
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

    private Double latitude;
    private Double longitude;

    private Location latestLocation;
    private String addressLine;
    private String zipCode;

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

        if(user.getLocation()!=null)
        {
            if(user.getLocation().getCoordinates()!=null)
            {
                this.longitude = user.getLocation().getCoordinates()[0];
                this.latitude = user.getLocation().getCoordinates()[1];
            }
        }

        this.latestLocation = user.getLatestLocation();
        if(user.getAddress()!=null)
        {
            Address address = user.getAddress();
            this.addressLine = address.getAddressLine();
            this.zipCode = address.getZipCode();
        }

    }
}
