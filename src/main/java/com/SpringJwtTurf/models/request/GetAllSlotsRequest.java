package com.SpringJwtTurf.models.request;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class GetAllSlotsRequest {
    private List<String> turfIds;
    private LocalDate date;
    private Integer slotDuration; // in Minutes
}

