package com.SpringJwtTurf.documents;

import com.SpringJwtTurf.enums.BookingStatus;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document
public class CancelledSlot {

    @Id
    private String _id;
    private String bookingId;
    private String userId;
    private String turfId;
    private Double price;
    private String status;
    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime timeStamp;

    public CancelledSlot(BookedTimeSlot bookedTimeSlot) {
        this.bookingId = bookedTimeSlot.getBookingId();
        this.userId = bookedTimeSlot.getUserId();
        this.turfId = bookedTimeSlot.getTurfId();
        this.price = bookedTimeSlot.getPrice();
        this.status = BookingStatus.CANCELLED_BY_USER.name();
        this.date = bookedTimeSlot.getDate();
        this.startTime = bookedTimeSlot.getStartTime();
        this.endTime = bookedTimeSlot.getEndTime();
        this.timeStamp = bookedTimeSlot.getTimeStamp();
    }
}
