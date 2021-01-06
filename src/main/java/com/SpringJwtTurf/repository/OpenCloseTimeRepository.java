package com.SpringJwtTurf.repository;

import com.SpringJwtTurf.documents.OpenCloseTime;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OpenCloseTimeRepository extends MongoRepository<OpenCloseTime,String> {

    @Query("{'day':?0}")
    OpenCloseTime findByDay(String day);

    @Query("{'date': {$gte: ?0}}")
    List<OpenCloseTime> findByDate(LocalDate date);
}
