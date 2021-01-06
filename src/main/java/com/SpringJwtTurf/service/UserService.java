package com.SpringJwtTurf.service;

import com.SpringJwtTurf.models.request.CreateUserRequest;
import com.SpringJwtTurf.models.request.CustomerProfileUpdateRequest;
import com.SpringJwtTurf.models.request.UpdateBookedTimeSlotRequest;
import com.SpringJwtTurf.models.request.UserLoginRequest;
import com.SpringJwtTurf.models.response.*;

public interface UserService {

    CreateUserResponse createNewUser(CreateUserRequest createUserRequest);

    CreateUserLoginResponse userLogin(UserLoginRequest userLoginRequest);

    CustomerProfileUpdateResponse updateCustomer(CustomerProfileUpdateRequest customerProfileUpdateRequest);

    AllBookedSlotsByUserResponse getAllBookedSlots(String userId);

    TimeSlotResponse updateBookedSlot(UpdateBookedTimeSlotRequest updateBookedTimeSlotRequest);
}
