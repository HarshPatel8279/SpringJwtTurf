package com.SpringJwtTurf.repository;

import com.SpringJwtTurf.documents.BookedTimeSlot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface BookedTimeSlotRepository extends MongoRepository<BookedTimeSlot,String> {

    @Query("{'userId':?0}")
    public List<BookedTimeSlot> findByUserId(String userId);

    @Query("{'bookingId':?0}")
    BookedTimeSlot findByBookingId(String bookingId);

    @Query("{'turfId':?0,'startTime':?1}")
    BookedTimeSlot findByTurfIdAndStartTime(String turfId, LocalDateTime startTime);

    @Query("{'date':{ $eq: ?0}, 'turfId':?1}")
    List<BookedTimeSlot> findByDateAndTurfId(LocalDate date,String turfId);

    @Query("{'date':{ $eq: ?0}}")
    List<BookedTimeSlot> findByDate(LocalDate date);



}
