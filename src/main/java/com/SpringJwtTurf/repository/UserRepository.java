package com.SpringJwtTurf.repository;

import com.SpringJwtTurf.documents.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query("{'phoneNumber' : ?0}")
    User findByPhoneNumber(String phoneNumber);

}
