package com.SpringJwtTurf.repository;

import com.SpringJwtTurf.documents.CancelledSlot;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CancelledSlotRepository extends MongoRepository<CancelledSlot,String> {

    @Query("{'userId':?0}")
    List<CancelledSlot> findByUserId(String userId);

}
