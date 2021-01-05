package com.SpringJwtTurf.models.response;

import com.SpringJwtTurf.documents.BookedTimeSlot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllBookedSlotsByUserResponse {

    private List<BookedTimeSlot> bookedTimeSlots;

}
