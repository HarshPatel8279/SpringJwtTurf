package com.SpringJwtTurf.models.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UpdateBookedTimeSlotRequest {

    private String bookingId;
    private Double price;
    private String turfId;
    private String userId;
    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

}
