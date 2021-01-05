package com.SpringJwtTurf.repository;

import com.SpringJwtTurf.documents.BookedTimeSlot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookedTimeSlotRepository extends MongoRepository<BookedTimeSlot,String> {

    @Query("{'userId':?0}")
    public List<BookedTimeSlot> findByUserId(String userId);

}
