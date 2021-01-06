package com.SpringJwtTurf.models.response;

import com.SpringJwtTurf.documents.BookedTimeSlot;
import com.SpringJwtTurf.documents.CancelledSlot;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TimeSlotResponse {

    private String bookingId;
    private String userId;
    private String turfId;
    private Double price;
    private String status;
    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime timeStamp;

    public TimeSlotResponse(BookedTimeSlot bookedTimeSlot) {
        this.bookingId = bookedTimeSlot.getBookingId();
        this.userId = bookedTimeSlot.getUserId();
        this.turfId = bookedTimeSlot.getTurfId();
        this.price = bookedTimeSlot.getPrice();
        this.status = bookedTimeSlot.getStatus();
        this.date = bookedTimeSlot.getDate();
        this.startTime = bookedTimeSlot.getStartTime();
        this.endTime = bookedTimeSlot.getEndTime();
        this.timeStamp = bookedTimeSlot.getTimeStamp();
    }

    public TimeSlotResponse(CancelledSlot cancelledSlot) {
        this.bookingId = cancelledSlot.getBookingId();
        this.userId = cancelledSlot.getUserId();
        this.turfId = cancelledSlot.getTurfId();
        this.price = cancelledSlot.getPrice();
        this.status = cancelledSlot.getStatus();
        this.date = cancelledSlot.getDate();
        this.startTime = cancelledSlot.getStartTime();
        this.endTime = cancelledSlot.getEndTime();
        this.timeStamp = cancelledSlot.getTimeStamp();
    }
}
