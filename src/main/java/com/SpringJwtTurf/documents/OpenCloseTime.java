package com.SpringJwtTurf.documents;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document
@Builder
public class OpenCloseTime {

    @Id
    private String _id;
//    private String day;
    private LocalDate date;
    private LocalDateTime openTime;
    private LocalDateTime closeTime;
    private LocalDateTime timestamp;

}

