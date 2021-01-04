package com.SpringJwtTurf.models.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
@AllArgsConstructor
public class Address {
    private String AddressLine;
    private String zipCode;
    private String city;
    private String state;
    private String country;
}
