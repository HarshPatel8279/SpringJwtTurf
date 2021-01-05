package com.SpringJwtTurf.service;

import com.SpringJwtTurf.models.request.CreateUserRequest;
import com.SpringJwtTurf.models.request.CustomerProfileUpdateRequest;
import com.SpringJwtTurf.models.request.UserLoginRequest;
import com.SpringJwtTurf.models.response.AllBookedSlotsByUserResponse;
import com.SpringJwtTurf.models.response.CreateUserLoginResponse;
import com.SpringJwtTurf.models.response.CreateUserResponse;
import com.SpringJwtTurf.models.response.CustomerProfileUpdateResponse;

public interface UserService {

    CreateUserResponse createNewUser(CreateUserRequest createUserRequest);

    CreateUserLoginResponse userLogin(UserLoginRequest userLoginRequest);

    CustomerProfileUpdateResponse updateCustomer(CustomerProfileUpdateRequest customerProfileUpdateRequest);

    AllBookedSlotsByUserResponse getAllBookedSlots(String userId);
}
