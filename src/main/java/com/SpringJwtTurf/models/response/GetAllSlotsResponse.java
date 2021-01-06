package com.SpringJwtTurf.models.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GetAllSlotsResponse {

    private List<TimeSlotResponse> turf01;
    private List<TimeSlotResponse> turf02;
    private List<TimeSlotResponse> turf03;

}
