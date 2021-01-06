package com.SpringJwtTurf.documents;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class BookedTimeSlot {
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

    @Override
    public String toString() {
        return "\nBookedTimeSlot{" +
                "_id='" + _id + '\'' +
                ", bookingId='" + bookingId + '\'' +
                ", userId='" + userId + '\'' +
                ", turfId='" + turfId + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", date=" + date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", timeStamp=" + timeStamp +
                "}\n";
    }
}
