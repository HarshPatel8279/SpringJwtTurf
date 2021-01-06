package com.SpringJwtTurf.models.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CancelOrUnavailableSlotRequest {

    private String turfId;
    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}

