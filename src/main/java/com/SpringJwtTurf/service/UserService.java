package com.SpringJwtTurf.service;

import com.SpringJwtTurf.documents.BookedTimeSlot;
import com.SpringJwtTurf.documents.OpenCloseTime;
import com.SpringJwtTurf.models.AllSlot;
import com.SpringJwtTurf.models.request.*;
import com.SpringJwtTurf.models.response.*;

public interface UserService {

    CreateUserResponse createNewUser(CreateUserRequest createUserRequest);

    CreateUserLoginResponse userLogin(UserLoginRequest userLoginRequest);

    CustomerProfileUpdateResponse updateCustomer(CustomerProfileUpdateRequest customerProfileUpdateRequest);

    AllBookedSlotsByUserResponse getAllBookedSlots(String userId);

    TimeSlotResponse updateBookedSlot(UpdateBookedTimeSlotRequest updateBookedTimeSlotRequest);

    TimeSlotResponse cancelBookedSlot(CancelOrUnavailableSlotRequest cancelOrUnavailableSlotRequest);

    GetAllSlotsResponse getAllSlotsByDate(GetAllSlotsRequest getAllSlotsRequest);

    void addOpenClose(OpenCloseTime openCloseTime);

    BookedTimeSlot addBookedTimeSlot(BookedTimeSlot bookedTimeSlot);

    void getAllSlot(AllSlot allSlot);
}
