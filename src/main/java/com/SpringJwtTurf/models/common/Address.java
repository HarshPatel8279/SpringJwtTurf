package com.SpringJwtTurf.models.common;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class Address {
    private String AddressLine;
    private String zipCode;
    private String city;
    private String state;
    private String country;
}
