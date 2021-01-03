package com.SpringJwtTurf.service;

import com.SpringJwtTurf.models.request.CreateUserRequest;
import com.SpringJwtTurf.models.response.CreateUserResponse;

public interface UserService {

    CreateUserResponse createNewUser(CreateUserRequest createUserRequest);

}
